package com.bilitech.yilimusic.music.service;

import com.bilitech.yilimusic.core.service.GeneralService;
import com.bilitech.yilimusic.music.dto.PlaylistDto;
import com.bilitech.yilimusic.music.dto.PlaylistSearchFilter;
import com.bilitech.yilimusic.music.entity.Playlist;
import org.springframework.data.domain.Page;

public interface PlaylistService extends GeneralService<Playlist, PlaylistDto> {
    Page<PlaylistDto> search(PlaylistSearchFilter playlistSearchFilter);

    PlaylistDto recommend(String id, Integer recommendFactor);

    PlaylistDto cancelRecommendation(String id);

    PlaylistDto makeSpecial(String id);

    PlaylistDto cancelSpecial(String id);
}
