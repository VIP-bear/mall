package com.project.mall.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.project.mall.config.AliyunConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 图片处理
 */

@Component
public class AliyunProvider {

    @Autowired
    private AliyunConfig aliyunConfig;

    // 可重入非公平锁
    private ReentrantLock lock;

    /**
     * 上传图片到服务器，返回图片url
     * @param uploadFile
     * @return
     */
    public String upload(MultipartFile uploadFile, String subDirectory) {
        String endpoint = aliyunConfig.getEndpoint();
        String bucketName = aliyunConfig.getBucketName();
        String folder = aliyunConfig.getFolder();
        String accessKeyId = aliyunConfig.getAccessKeyId();
        String accessKeySecret = aliyunConfig.getAccessKeySecret();
        Integer expires = aliyunConfig.getExpires();

        URL url;
        String imageUrl = null;
        // 图片名
        String fileName = UUID.randomUUID().toString() + uploadFile.getOriginalFilename();
        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 上传
            lock.lock();    // 获取锁
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(uploadFile.getInputStream().available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(uploadFile.getContentType());
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            ossClient.putObject(bucketName, folder+subDirectory+fileName, uploadFile.getInputStream(), objectMetadata);
            // 获取图片url,第二个参数图片地址，第三个参数图片地址有效期
            url = ossClient.generatePresignedUrl(bucketName, folder+subDirectory+fileName, new Date(new Date().getTime() + expires));
            if (url != null){
                imageUrl = url.toString();
            }else {
                return null;
            }
            // 关闭client
            ossClient.shutdown();

        }catch (IOException e){
            return null;
        } finally {
            lock.unlock();  // 释放锁
        }
        return imageUrl;
    }

}
