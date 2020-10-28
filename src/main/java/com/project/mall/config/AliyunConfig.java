package com.project.mall.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云oss配置
 */
@Configuration
@Data
public class AliyunConfig {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.bucket-name}")
    private String bucketName;

    @Value("${aliyun.oss.folder}")
    private String folder;

    @Value("${aliyun.oss.public-key}")
    private String accessKeyId;

    @Value("${aliyun.oss.private-key}")
    private String accessKeySecret;

    @Value("${aliyun.oss.expires}")
    private Integer expires;

}
