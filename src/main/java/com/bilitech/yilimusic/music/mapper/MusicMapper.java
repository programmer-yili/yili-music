package com.bilitech.yilimusic.music.mapper;

import com.bilitech.yilimusic.core.mapper.FileMapper;
import com.bilitech.yilimusic.core.mapper.MapperInterface;
import com.bilitech.yilimusic.music.dto.ArtistDto;
import com.bilitech.yilimusic.music.dto.MusicCreateRequest;
import com.bilitech.yilimusic.music.dto.MusicDto;
import com.bilitech.yilimusic.music.dto.MusicUpdateRequest;
import com.bilitech.yilimusic.music.entity.Music;
import com.bilitech.yilimusic.music.vo.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        uses = {FileMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface MusicMapper extends MapperInterface<Music, MusicDto> {
    @Mapping(source = "fileId", target = "file.id")
    @Mapping(target = "artistList", source = "artistIds")
    MusicDto toDto(MusicCreateRequest musicCreateRequest);

    @Mapping(source = "fileId", target = "file.id")
    @Mapping(target = "artistList", source = "artistIds")
    MusicDto toDto(MusicUpdateRequest musicUpdateRequest);

    MusicVo toVo(MusicDto musicDto);


    default List<ArtistDto> mapArtistList(List<String> artistIds) {
        List<ArtistDto> artistList = new ArrayList<ArtistDto>();
        for (String id : artistIds) {
            ArtistDto artistDto = new ArtistDto();
            artistDto.setId(id);
            artistList.add(artistDto);
        }
        return artistList;
    }
}
