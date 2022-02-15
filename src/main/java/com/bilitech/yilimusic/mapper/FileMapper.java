package com.bilitech.yilimusic.mapper;

import com.bilitech.yilimusic.dto.FileUploadRequest;
import com.bilitech.yilimusic.entity.File;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);
}
