package com.projeto.s3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.projeto.s3.service.model.UpdloadResult;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;

@Service
public class S3Service {

    private static Logger LOG = LoggerFactory.getLogger(S3Service.class);

    @Autowired
    private AmazonS3 s3client;

    @Value("${s3.bucket}")
    private String bucketName;

    public UpdloadResult uploadFile(MultipartFile file, String name) {
        try {
            String originalName = file.getOriginalFilename();
            String extension = FilenameUtils.getExtension(originalName);
            String fileName = name + Instant.now().toString() + "." + extension;

            InputStream is = file.getInputStream();
            String contentType = file.getContentType();

            URL url = uploadFile(is, fileName, contentType);
            return new UpdloadResult(fileName, url);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeFile(String fileName){
        LOG.info("Remove start");
        s3client.deleteObject(bucketName, fileName);
        LOG.info("Remove finishes");

    }


    private URL uploadFile(InputStream is, String fileName, String contentType) {
        ObjectMetadata meta = new ObjectMetadata();
        LOG.info("Upload start");
        s3client.putObject(bucketName, fileName, is, meta);
        LOG.info("Upload end");
        return s3client.getUrl(bucketName, fileName);

    }
}
