package com.bilitech.yilimusic.mapper;

import com.bilitech.yilimusic.dto.FileDto;
import com.bilitech.yilimusic.dto.FileUploadRequest;
import com.bilitech.yilimusic.entity.File;
import com.bilitech.yilimusic.vo.FileVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);

    FileVo toVo(FileDto fileDto);

    FileDto toDto(File file);
}
