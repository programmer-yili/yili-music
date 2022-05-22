package com.bilitech.yilimusic.music.mapper;

import com.bilitech.yilimusic.core.mapper.FileMapper;
import com.bilitech.yilimusic.core.mapper.MapperInterface;
import com.bilitech.yilimusic.music.dto.ArtistCreateRequest;
import com.bilitech.yilimusic.music.dto.ArtistDto;
import com.bilitech.yilimusic.music.dto.ArtistUpdateRequest;
import com.bilitech.yilimusic.music.entity.Artist;
import com.bilitech.yilimusic.music.vo.ArtistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {FileMapper.class, MusicMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArtistMapper extends MapperInterface<Artist, ArtistDto> {

    @Mapping(source = "photoId", target = "photo.id")
    ArtistDto toDto(ArtistCreateRequest artistCreateRequest);

    ArtistDto toDto(ArtistUpdateRequest artistUpdateRequest);

    ArtistVo toVo(ArtistDto artistDto);
}
