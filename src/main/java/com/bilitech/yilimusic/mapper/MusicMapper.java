package com.bilitech.yilimusic.mapper;

import com.bilitech.yilimusic.dto.MusicCreateRequest;
import com.bilitech.yilimusic.dto.MusicDto;
import com.bilitech.yilimusic.dto.MusicUpdateRequest;
import com.bilitech.yilimusic.entity.Music;
import com.bilitech.yilimusic.vo.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MusicMapper {
    MusicDto toDto(Music music);

    MusicVo toVo(MusicDto musicDto);

    Music createEntity(MusicCreateRequest musicCreateRequest);

    Music updateEntity(@MappingTarget Music music, MusicUpdateRequest musicUpdateRequest);
}
