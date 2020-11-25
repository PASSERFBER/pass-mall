package com.pas.mall.controller;


import com.pas.mall.entity.Result;
import io.minio.MinioClient;
import io.minio.policy.PolicyType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UploadController {
    @Value("${minio.endpoint}")
    private String endpoint;
    @Value("${minio.bucketName}")
    private String bucketName;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;

    @PostMapping("/upLoadFile")
    public Result upLoadFile(MultipartFile file){
        Result result = new Result();
        try {
            MinioClient minioClient = new MinioClient(endpoint,accessKey,secretKey);
            boolean isExist = minioClient.bucketExists(bucketName);
            if(!isExist){
                minioClient.makeBucket(bucketName);
                minioClient.setBucketPolicy(bucketName,"*.*", PolicyType.READ_ONLY);
            }

            String fileName = file.getOriginalFilename();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            //设置存储对象名称
            String objectName = sdf.format(new Date()) + "/" +fileName;
            //把存储对象上传到存储桶中
            minioClient.putObject(bucketName,objectName,file.getInputStream(),file.getContentType());
            System.out.println("文件上传成功");

            String objectUrl = minioClient.getObjectUrl(bucketName,objectName);
            System.out.println(objectUrl);

            result.setMessage(objectUrl);
            result.setSuccess(true);


        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "文件存储失败");
        }
        return result;
    }

}
