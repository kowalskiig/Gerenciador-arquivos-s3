package com.projeto.s3.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class FileResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String fileName;
    private String fileUrl;
    private Instant uploadAt;

    public FileResponseDTO(){}

    public FileResponseDTO(Long id, String fileName, String fileUrl, Instant uploadAt) {
        this.id = id;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.uploadAt = uploadAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Instant getUploadAt() {
        return uploadAt;
    }

    public void setUploadAt(Instant uploadAt) {
        this.uploadAt = uploadAt;
    }
}
