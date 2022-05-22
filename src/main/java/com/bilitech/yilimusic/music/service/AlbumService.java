package com.bilitech.yilimusic.music.service;

import com.bilitech.yilimusic.core.service.GeneralService;
import com.bilitech.yilimusic.music.dto.AlbumDto;
import com.bilitech.yilimusic.music.dto.AlbumSearchFilter;
import com.bilitech.yilimusic.music.entity.Album;
import org.springframework.data.domain.Page;

public interface AlbumService extends GeneralService<Album, AlbumDto> {
    Page<AlbumDto> search(AlbumSearchFilter albumSearchFilter);

    AlbumDto recommend(String id, Integer recommendFactor);

    AlbumDto cancelRecommendation(String id);
}
