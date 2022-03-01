package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.dto.FileUploadDto;

import java.io.IOException;

public interface StorageService {
    FileUploadDto initFileUpload() throws IOException;

    String getFileUri(String fileKey);
}
