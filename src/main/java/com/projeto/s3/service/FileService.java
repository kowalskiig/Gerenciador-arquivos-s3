package com.projeto.s3.service;

import com.projeto.s3.dto.FileDTO;
import com.projeto.s3.dto.FileResponseDTO;
import com.projeto.s3.entity.File;
import com.projeto.s3.mapper.FileMapper;
import com.projeto.s3.repository.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

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
        URL url = s3Service.uploadFile(file);
        File enity = new File(
                url.toString(),
                fileName);

        enity = fileRepository.save(enity);
        return FileMapper.toDto(enity);
    }
}
