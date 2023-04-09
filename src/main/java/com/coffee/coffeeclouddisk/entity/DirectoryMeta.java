package com.coffee.coffeeclouddisk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author Nebula
 * @Description 云盘目录文件元数据，请提防线程安全问题
 * @date 2023/3/21 18:57
 */
@Data
@ToString
public class DirectoryMeta implements Serializable {

    @Serial
    private static final long serialVersionUID = 3866336729340083125L;
    /**
     * 文件夹元数据Id
     */
    private Long directoryMetaId;
    /**
     * 文件夹大小
     */
    private Long size;
    /**
     * 文件夹名
     */
    private String directoryName;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifyTime;
    /**
     * 上级文件夹元数据Id
     */
    private Long parentMetaId;
    /**
     * <文件夹名,文件夹元数据Id>
     * 请使用Number类来代替Long类，否则JSON类型转换时会出现数字转为Integer类型的问题
     */
    private Map<String,Number> childrenDirectoryMeta;
    /**
     * <文件名，文件元数据Id>
     *     请使用Number类来代替Long类，否则JSON类型转换时会出现数字转为Integer类型的问题
     */
    private Map<String,Number> childrenFileMeta;

    public DirectoryMeta(Long directoryMetaId, Long size, String directoryName, Date modifyTime, Long parentMetaId, Map<String, Number> childrenDirectoryMeta, Map<String, Number> childrenFileMeta) {
        this.directoryMetaId = directoryMetaId;
        this.size = size;
        this.directoryName = directoryName;
        this.modifyTime = modifyTime;
        this.parentMetaId = parentMetaId;
        this.childrenDirectoryMeta = childrenDirectoryMeta;
        this.childrenFileMeta = childrenFileMeta;
    }

    public DirectoryMeta() {
    }


}
