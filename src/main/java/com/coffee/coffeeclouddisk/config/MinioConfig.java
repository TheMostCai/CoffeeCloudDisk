package com.coffee.coffeeclouddisk.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/23 13:00
 */
@Data
public class MinioConfig {
    public static final String ipAddress = "http://192.168.3.121";

    public static final int port = 9000;

    public static final String accessKey = "uPPU2MT3wyYPEbNZ";

    public static final String secretKey = "riluTCI133FrHuYSt3ur1HGgnOtWz4wI";

    public static final boolean secure = false;
}
