package com.bilitech.yilimusic.mapper;

import com.bilitech.yilimusic.dto.MusicCreateRequest;
import com.bilitech.yilimusic.dto.MusicDto;
import com.bilitech.yilimusic.dto.MusicUpdateRequest;
import com.bilitech.yilimusic.entity.Music;
import com.bilitech.yilimusic.vo.MusicVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = FileMapper.class)
public interface MusicMapper extends MapperInterface<Music, MusicDto> {
    MusicDto toDto(MusicCreateRequest musicCreateRequest);

    MusicDto toDto(MusicUpdateRequest musicUpdateRequest);

    MusicVo toVo(MusicDto musicDto);
}
