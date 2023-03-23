package com.coffee.coffeeclouddisk.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/22 20:27
 */
@Data
public class TrueFile {
    private Long trueFileId;
    private String uuidName;
    private Integer links;
    private Integer userId;
    private Date uploadTime;
    private String location;
    /**
     * 文件md5值
     */
    private String md5;
}
