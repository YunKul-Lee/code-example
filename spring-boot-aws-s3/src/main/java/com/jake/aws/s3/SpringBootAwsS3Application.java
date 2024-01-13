package com.jake.aws.s3;

import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.S3Object;
import com.jake.aws.s3.service.S3Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SpringBootAwsS3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAwsS3Application.class, args);
    }

//    @Bean
//    public ApplicationRunner applicationRunner(S3Service s3Service) {
//
//        return args -> {
//            try {
//                S3Object s3Object = s3Service.getFile("sample.png");
//                log.info(s3Object.getKey());
//            } catch(AmazonS3Exception e) {
//                log.error(e.getMessage());
//            }
//        };
//    }
}
