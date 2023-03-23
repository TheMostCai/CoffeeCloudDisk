package com.coffee.coffeeclouddisk;

import com.coffee.coffeeclouddisk.util.MinioUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.coffee.coffeeclouddisk.dao"})
@ConfigurationPropertiesScan(basePackageClasses = {MinioUtil.class})
public class CoffeeCloudDiskApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeCloudDiskApplication.class, args);
    }

}
