package com.bilitech.yilimusic.service.impl;

import com.bilitech.yilimusic.dto.FileUploadDto;
import com.bilitech.yilimusic.service.StorageService;
import org.springframework.stereotype.Service;

@Service("COS")
public class CosStorageServiceImpl implements StorageService {
    @Override
    public FileUploadDto initFileUpload() {
        return null;
    }
}
