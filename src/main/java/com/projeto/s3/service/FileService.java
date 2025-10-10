package com.projeto.s3.service;

import com.projeto.s3.dto.FileResponseDTO;
import com.projeto.s3.entity.File;
import com.projeto.s3.exception.ResourceNotFoundException;
import com.projeto.s3.mapper.FileMapper;
import com.projeto.s3.repository.FileRepository;
import com.projeto.s3.service.model.UpdloadResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.time.Instant;
import java.util.List;

@Service
public class FileService {
    private final S3Service s3Service;
    private final FileRepository fileRepository;

    public FileService(S3Service s3Service, FileRepository fileRepository) {
        this.s3Service = s3Service;
        this.fileRepository = fileRepository;
    }

    @Transactional
    public FileResponseDTO uploadFile(MultipartFile file, String fileName) {
        UpdloadResult result = s3Service.uploadFile(file, fileName);

        File entity = new File(
                result.fileUrl().toString(),
                result.fileName()
        );

        entity = fileRepository.save(entity);
        return FileMapper.toDto(entity);
    }

    @Transactional
    public void removeFile(Long id){
        File file = fileRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Id não encontrado"));
        s3Service.removeFile(file.getFileName());

        fileRepository.deleteById(id);

    }

    @Transactional
    public FileResponseDTO updateFile(Long id, MultipartFile file){
        File entity = fileRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Id não encontrado"));

        URL url = s3Service.updateFile(entity.getFileName(), file);

        entity.setFileUrl(url.toString());
        entity.setUploadAt(Instant.now());
        entity = fileRepository.save(entity);

        return FileMapper.toDto(entity);

    }

    @Transactional(readOnly = true)
    public List<FileResponseDTO> findAllFiles(){
        List<File> files = fileRepository.findAllFile();

        return files.stream().map(FileMapper::toDto).toList();

    }
}
