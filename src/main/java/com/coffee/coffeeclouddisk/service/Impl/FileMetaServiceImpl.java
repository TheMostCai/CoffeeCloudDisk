package com.coffee.coffeeclouddisk.service.Impl;

import com.coffee.coffeeclouddisk.dao.FileMetaDao;
import com.coffee.coffeeclouddisk.entity.FileMeta;
import com.coffee.coffeeclouddisk.service.FileMetaService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/23 17:40
 */
@Service("fileMetaService")
public class FileMetaServiceImpl implements FileMetaService {

    @Resource
    private FileMetaDao fileMetaDao;

    @Override
    public FileMeta get() {
        return fileMetaDao.select();
    }
}
