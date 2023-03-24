package com.coffee.coffeeclouddisk.service.Impl;

import com.coffee.coffeeclouddisk.dao.DirectoryMetaDao;
import com.coffee.coffeeclouddisk.entity.DirectoryMeta;
import com.coffee.coffeeclouddisk.service.DirectoryMetaService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/23 16:23
 */
@Service("directoryMetaService")
public class DirectoryMetaServiceImpl implements DirectoryMetaService {

    @Resource
    private DirectoryMetaDao directoryMetaDao;

    @Override
    public int insert(DirectoryMeta directoryMeta) {
        return directoryMetaDao.insert(directoryMeta);
    }


    @Override
    public DirectoryMeta queryById(Long directoryMetaId) {
        return directoryMetaDao.queryById(directoryMetaId);
    }
}
