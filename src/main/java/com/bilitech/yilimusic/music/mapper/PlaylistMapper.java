package com.bilitech.yilimusic.music.mapper;

import com.bilitech.yilimusic.core.mapper.FileMapper;
import com.bilitech.yilimusic.core.mapper.MapperInterface;
import com.bilitech.yilimusic.music.dto.PlaylistCreateRequest;
import com.bilitech.yilimusic.music.dto.PlaylistDto;
import com.bilitech.yilimusic.music.entity.Playlist;
import com.bilitech.yilimusic.music.vo.PlaylistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {FileMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PlaylistMapper extends MapperInterface<Playlist, PlaylistDto> {

    @Mapping(source = "coverId", target = "cover.id")
    PlaylistDto toDto(PlaylistCreateRequest playlistCreateRequest);

    PlaylistVo toVo(PlaylistDto playlistDto);
}
