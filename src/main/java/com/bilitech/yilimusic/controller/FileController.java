package com.bilitech.yilimusic.controller;

import com.bilitech.yilimusic.dto.FileUploadRequest;
import com.bilitech.yilimusic.mapper.FileUploadMapper;
import com.bilitech.yilimusic.service.FileService;
import com.bilitech.yilimusic.vo.FileUploadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/files")
public class FileController {

    private FileService fileService;

    private FileUploadMapper fileUploadMapper;

    @PostMapping("/upload_init")
    public FileUploadVo initUpload(@Validated @RequestBody FileUploadRequest fileUploadRequest) {
        return fileUploadMapper.toVo(fileService.initUpload(fileUploadRequest));
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    public void setFileUploadMapper(FileUploadMapper fileUploadMapper) {
        this.fileUploadMapper = fileUploadMapper;
    }
}
