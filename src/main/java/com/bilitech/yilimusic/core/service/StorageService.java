package com.bilitech.yilimusic.core.service;

import com.bilitech.yilimusic.core.dto.FileUploadDto;

import java.io.IOException;

public interface StorageService {
    FileUploadDto initFileUpload() throws IOException;

    String getFileUri(String fileKey);
}
