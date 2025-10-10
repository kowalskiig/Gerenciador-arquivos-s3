package com.projeto.s3.controller;

import com.projeto.s3.dto.FileResponseDTO;
import com.projeto.s3.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<FileResponseDTO> updloadFile(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName){
        FileResponseDTO result = fileService.uploadFile(file, fileName);
        return ResponseEntity.ok(result);


    }
    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<Void> removeFile(@PathVariable Long id){
        fileService.removeFile(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<FileResponseDTO> updateFile(@PathVariable Long id, @RequestParam("file") MultipartFile file){
        FileResponseDTO result = fileService.updateFile(id, file);
        return ResponseEntity.ok(result);
    }
}
