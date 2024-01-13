package com.jake.aws.s3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class S3Service {

    private final AmazonS3 s3client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public void uploadFile(String keyName, MultipartFile file) throws IOException {
        PutObjectResult putObjectResult =s3client.putObject(bucketName, keyName, file.getInputStream(), null);
        log.info(putObjectResult.getMetadata().toString());
    }

    public S3Object getFile(String keyName) {
        return s3client.getObject(bucketName, keyName);
    }
}
