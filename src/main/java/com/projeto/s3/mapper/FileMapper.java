package com.projeto.s3.mapper;

import com.projeto.s3.dto.FileResponseDTO;
import com.projeto.s3.entity.File;

public class FileMapper {

    public static FileResponseDTO toDto(File entity){
        return new FileResponseDTO(
                entity.getId(),
                entity.getFileName(),
                entity.getFileUrl(),
                entity.getUploadAt()
        );

    }
}
