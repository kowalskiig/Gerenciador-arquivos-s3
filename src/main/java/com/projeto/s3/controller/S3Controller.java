package com.projeto.s3.controller;

import com.projeto.s3.dto.UriDTO;
import com.projeto.s3.service.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/bucket")
public class S3Controller {

    private final CrudService crudService;

    public S3Controller(CrudService crudService) {
        this.crudService = crudService;
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<UriDTO> updloadFile(@RequestParam("file") MultipartFile file){
        UriDTO result = crudService.uploadFile(file);
        return ResponseEntity.ok(result);


    }
}
