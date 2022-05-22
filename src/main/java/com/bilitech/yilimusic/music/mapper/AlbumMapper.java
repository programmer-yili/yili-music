package com.bilitech.yilimusic.music.mapper;

import com.bilitech.yilimusic.core.mapper.FileMapper;
import com.bilitech.yilimusic.core.mapper.MapperInterface;
import com.bilitech.yilimusic.music.dto.AlbumCreateRequest;
import com.bilitech.yilimusic.music.dto.AlbumDto;
import com.bilitech.yilimusic.music.dto.AlbumUpdateRequest;
import com.bilitech.yilimusic.music.entity.Album;
import com.bilitech.yilimusic.music.vo.AlbumVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {FileMapper.class, ArtistMapper.class, MusicMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AlbumMapper extends MapperInterface<Album, AlbumDto> {

    @Mapping(source = "coverId", target = "cover.id")
    @Mapping(source = "artistIds", target = "artists")
    AlbumDto toDto(AlbumCreateRequest albumCreateRequest);

    @Mapping(source = "coverId", target = "cover.id")
    @Mapping(source = "artistIds", target = "artists")
    AlbumDto toDto(AlbumUpdateRequest albumUpdateRequest);


    AlbumVo toVo(AlbumDto albumDto);
}
