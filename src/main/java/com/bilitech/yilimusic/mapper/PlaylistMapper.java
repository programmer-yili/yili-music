package com.bilitech.yilimusic.mapper;

import com.bilitech.yilimusic.dto.PlaylistDto;
import com.bilitech.yilimusic.entity.Playlist;
import com.bilitech.yilimusic.vo.PlaylistVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = MusicMapper.class)
public interface PlaylistMapper {
    PlaylistDto toDto(Playlist playlist);

    PlaylistVo toVo(PlaylistDto playlistDto);
}
