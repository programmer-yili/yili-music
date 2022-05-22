package com.bilitech.yilimusic.music.service;


import com.bilitech.yilimusic.core.service.GeneralService;
import com.bilitech.yilimusic.music.dto.ArtistDto;
import com.bilitech.yilimusic.music.dto.ArtistSearchFilter;
import com.bilitech.yilimusic.music.entity.Artist;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArtistService extends GeneralService<Artist, ArtistDto> {
    List<ArtistDto> list();

    Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter);

    ArtistDto recommend(String id, Integer recommendFactor);

    ArtistDto cancelRecommendation(String id);
}
