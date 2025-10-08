package com.projeto.s3.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileUrl;
    private Instant uploadAt;

    public File(){}

    public File(Long id, String fileUrl, String fileName, Instant uploadAt) {
        this.id = id;
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.uploadAt = uploadAt;
    }

    public Long getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public Instant getUploadAt() {
        return uploadAt;
    }
}
