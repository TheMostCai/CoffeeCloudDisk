package com.coffee.coffeeclouddisk.util;

import com.coffee.coffeeclouddisk.config.MinioConfig;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/22 20:55
 */

public class MinioUtil {
    public static MinioClient getMinioClient(){
        return MinioClient.builder().endpoint(MinioConfig.ipAddress,MinioConfig.port,MinioConfig.secure).credentials(MinioConfig.accessKey,MinioConfig.secretKey).build();
    }

    public static String postFile(MultipartFile multipartFile, String fileName,MinioClient minioClient){
        ObjectWriteResponse objectWriteResponse;
        try {
            InputStream stream = multipartFile.getInputStream();
            objectWriteResponse = minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket("coffee-cloud-disk")
                            .object(fileName)
                            .contentType(multipartFile.getContentType())
                            .stream(stream,stream.available(),-1)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return objectWriteResponse.object();
    }



}
