package com.coffee.coffeeclouddisk.dao;

import com.coffee.coffeeclouddisk.entity.DirectoryMeta;
import org.springframework.stereotype.Repository;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/23 15:35
 */
public interface DirectoryMetaDao {
    int insert(DirectoryMeta directoryMeta);

    DirectoryMeta queryById(Long directoryMetaId);
}
