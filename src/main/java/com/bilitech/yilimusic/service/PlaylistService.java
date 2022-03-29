package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.dto.PlaylistDto;
import com.bilitech.yilimusic.dto.PlaylistSearchFilter;
import com.bilitech.yilimusic.entity.Playlist;
import org.springframework.data.domain.Page;

public interface PlaylistService extends GeneralService<Playlist, PlaylistDto> {
    Page<PlaylistDto> search(PlaylistSearchFilter playlistSearchFilter);

    PlaylistDto recommend(String id, Integer recommendFactor);

    PlaylistDto cancelRecommendation(String id);

    PlaylistDto makeSpecial(String id);

    PlaylistDto cancelSpecial(String id);
}
