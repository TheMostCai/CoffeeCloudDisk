package com.coffee.coffeeclouddisk.dao;

import com.coffee.coffeeclouddisk.entity.DirectoryMeta;
import com.coffee.coffeeclouddisk.entity.FileMeta;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/23 17:36
 */
public interface FileMetaDao {
    int insert(FileMeta fileMeta);
    FileMeta select();
}
