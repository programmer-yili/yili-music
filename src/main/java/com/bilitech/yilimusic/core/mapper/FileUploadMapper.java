package com.bilitech.yilimusic.core.mapper;

import com.bilitech.yilimusic.core.dto.FileUploadDto;
import com.bilitech.yilimusic.core.vo.FileUploadVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileUploadMapper {
    FileUploadVo toVo(FileUploadDto fileUploadDto);
}
