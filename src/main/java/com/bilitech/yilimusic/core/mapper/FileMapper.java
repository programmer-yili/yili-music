package com.bilitech.yilimusic.core.mapper;

import com.bilitech.yilimusic.core.dto.FileDto;
import com.bilitech.yilimusic.core.dto.FileUploadRequest;
import com.bilitech.yilimusic.core.vo.FileVo;
import com.bilitech.yilimusic.core.entity.File;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(FileMapperDecorator.class)
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);

    FileVo toVo(FileDto fileDto);

    FileDto toDto(File file);

    File toEntity(FileDto fileDto);
}
