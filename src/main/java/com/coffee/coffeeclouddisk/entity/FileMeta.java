package com.coffee.coffeeclouddisk.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/21 18:57
 */
@Data
public class FileMeta  implements Serializable {
    @Serial
    private static final long serialVersionUID = -4285197901751597699L;
    /**
     * 文件元数据Id
     */
    private Long fileMetaId;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 上级文件夹元数据Id
     */
    private Long parentMetaId;
    /**
     * 对应实际文件的Id
     */
    private Long trueFileId;


}
