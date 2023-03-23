package com.coffee.coffeeclouddisk.util;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/22 20:55
 */
@Data
public class MinioUtil {
    @Value("${ipAddress}")
    private static String ipAddress;
    @Value("${port}")
    private static int port;
    @Value("${accessKey}")
    private static String accessKey;
    @Value("${secretKey}")
    private static String secretKey;
    @Value("${secure}")
    private static boolean secure;

    public static MinioClient getMinioClient() {
        return MinioClient.builder().endpoint(ipAddress, port, secure).credentials(accessKey, secretKey).build();
    }
}
