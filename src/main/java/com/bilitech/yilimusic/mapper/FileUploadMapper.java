package com.bilitech.yilimusic.mapper;

import com.bilitech.yilimusic.dto.FileUploadDto;
import com.bilitech.yilimusic.vo.FileUploadVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileUploadMapper {
    FileUploadVo toVo(FileUploadDto fileUploadDto);
}
