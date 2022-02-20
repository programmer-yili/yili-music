package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.dto.FileDto;
import com.bilitech.yilimusic.dto.FileUploadDto;
import com.bilitech.yilimusic.dto.FileUploadRequest;

import java.io.IOException;

public interface FileService {
    FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException;

    FileDto finishUpload(String id);
}
