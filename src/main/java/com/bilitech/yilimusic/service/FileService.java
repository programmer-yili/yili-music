package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.dto.FileUploadDto;
import com.bilitech.yilimusic.dto.FileUploadRequest;

public interface FileService {

    FileUploadDto initUpload(FileUploadRequest fileUploadRequest);
}
