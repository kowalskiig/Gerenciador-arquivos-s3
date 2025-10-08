package com.projeto.s3.dto;

import java.io.Serial;
import java.io.Serializable;

public class FileDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String fileName;

    public FileDTO(){
    }

    public FileDTO(String fileName){
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
