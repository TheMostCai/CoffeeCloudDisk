package com.coffee.coffeeclouddisk.entity;

import lombok.Data;

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
    private Date modifyTime;
    /**
     * 上级文件夹元数据Id
     */
    private Long parentMetaId;
    /**
     * <文件夹名,文件夹元数据Id>
     */
    private Map<String,Long> childrenDirectoryMeta;
    /**
     * <文件名，文件元数据Id>
     */
    private Map<String,Long> childrenFileMeta;

    public DirectoryMeta(Long directoryMetaId, Long size, String directoryName, Date modifyTime, Long parentMetaId, Map<String, Long> childrenDirectoryMeta, Map<String, Long> childrenFileMeta) {
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
