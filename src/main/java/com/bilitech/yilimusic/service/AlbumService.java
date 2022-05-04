package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.dto.AlbumDto;
import com.bilitech.yilimusic.dto.AlbumSearchFilter;
import com.bilitech.yilimusic.entity.Album;
import org.springframework.data.domain.Page;

public interface AlbumService extends GeneralService<Album, AlbumDto> {
    Page<AlbumDto> search(AlbumSearchFilter albumSearchFilter);

    AlbumDto recommend(String id, Integer recommendFactor);

    AlbumDto cancelRecommendation(String id);
}
