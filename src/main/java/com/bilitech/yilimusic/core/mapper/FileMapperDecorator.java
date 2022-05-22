package com.bilitech.yilimusic.core.mapper;

import com.bilitech.yilimusic.core.dto.FileDto;
import com.bilitech.yilimusic.core.entity.File;
import com.bilitech.yilimusic.core.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

public abstract class FileMapperDecorator implements FileMapper {

    @Autowired
    @Qualifier("delegate")
    private FileMapper delegate;

    @Autowired
    private Map<String, StorageService> storageServices;

    @Override
    public FileDto toDto(File file) {
        FileDto fileDto = delegate.toDto(file);

        if (fileDto == null) {
            return null;
        }
        if (fileDto.getStorage() == null) {
            return null;
        }
        fileDto.setUri(storageServices.get(fileDto.getStorage().name()).getFileUri(fileDto.getKey()));
        return fileDto;
    }
}
