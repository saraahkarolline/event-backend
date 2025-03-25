package com.backend.evetostec.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import org.springframework.beans.factory.annotation.Value;

@Configuration
public class AWSConfig {
    @Value("${aws.region}")
    private String awsRegion;

    @Bean
    public AmazonS3 createS3Instance(){
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(awsRegion)
                .build();
    }

}
