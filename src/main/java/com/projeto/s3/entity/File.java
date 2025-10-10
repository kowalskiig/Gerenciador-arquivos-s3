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

    public File(String fileUrl, String fileName) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        uploadAt = Instant.now();
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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setUploadAt(Instant uploadAt) {
        this.uploadAt = uploadAt;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
