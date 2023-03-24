package com.coffee.coffeeclouddisk.controller;

import com.coffee.coffeeclouddisk.entity.FileMeta;
import com.coffee.coffeeclouddisk.service.FileMetaService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/23 17:39
 */
@RestController
@RequestMapping("fileMeta")
public class FileMetaController {

    @Resource
    FileMetaService fileMetaService;

    @GetMapping("/get")
    public FileMeta get(){
        return fileMetaService.get();
    }
}
