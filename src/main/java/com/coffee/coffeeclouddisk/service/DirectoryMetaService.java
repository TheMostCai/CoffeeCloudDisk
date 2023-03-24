package com.coffee.coffeeclouddisk.service;

import com.coffee.coffeeclouddisk.entity.DirectoryMeta;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/23 16:24
 */
public interface DirectoryMetaService {
    int insert(DirectoryMeta directoryMeta);

    DirectoryMeta queryById(Long directoryMetaId);
}
