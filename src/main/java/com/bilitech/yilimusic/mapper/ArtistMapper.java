package com.bilitech.yilimusic.mapper;

import com.bilitech.yilimusic.dto.ArtistCreateRequest;
import com.bilitech.yilimusic.dto.ArtistDto;
import com.bilitech.yilimusic.dto.ArtistUpdateRequest;
import com.bilitech.yilimusic.entity.Artist;
import com.bilitech.yilimusic.vo.ArtistVo;
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
