package com.bilitech.yilimusic.core.service;

import com.bilitech.yilimusic.core.dto.FileDto;
import com.bilitech.yilimusic.core.dto.FileUploadDto;
import com.bilitech.yilimusic.core.dto.FileUploadRequest;
import com.bilitech.yilimusic.core.entity.File;
import com.bilitech.yilimusic.core.enums.Storage;

import java.io.IOException;

public interface FileService {
    FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException;

    FileDto finishUpload(String id);

    Storage getDefaultStorage();

    File getFileEntity(String id);
}
