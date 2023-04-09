package com.coffee.coffeeclouddisk.controller;

import com.coffee.coffeeclouddisk.entity.DirectoryMeta;
import com.coffee.coffeeclouddisk.service.DirectoryMetaService;
import jakarta.annotation.Resource;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/23 16:28
 */
@RestController
@RequestMapping("directoryMeta")
public class DirectoryMetaController {

    @Resource
    private DirectoryMetaService directoryMetaService;

    @PostMapping("/directory")
    public int postDirectory(@RequestParam String size,
                             @RequestParam String directoryName,
                             @RequestParam String parentMetaId){
        Date date = new Date();
        HashMap<String, Number> childrenDir = new HashMap<>();
        childrenDir.put("dirName", 1L);
        HashMap<String, Number> childrenFile = new HashMap<>();
        childrenFile.put("fileName", 1L);
        DirectoryMeta directoryMeta = new DirectoryMeta(100L, 1L, "456", date, 1L, childrenDir, childrenFile);
        System.out.println(directoryMeta.toString());
        return directoryMetaService.insert(directoryMeta);
    }

    @GetMapping("/directory/{directoryMetaId}")
    public DirectoryMeta queryDirectoryMeta(@PathVariable("directoryMetaId")String directoryMetaId){
        return directoryMetaService.queryById(Long.valueOf(directoryMetaId));
    }
}
