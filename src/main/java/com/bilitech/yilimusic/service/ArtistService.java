package com.bilitech.yilimusic.service;


import com.bilitech.yilimusic.dto.ArtistCreateRequest;
import com.bilitech.yilimusic.dto.ArtistDto;
import com.bilitech.yilimusic.dto.ArtistUpdateRequest;

import java.util.List;

public interface ArtistService {
    ArtistDto create(ArtistCreateRequest artistCreateRequest);

    ArtistDto update(String id, ArtistUpdateRequest artistUpdateRequest);

    List<ArtistDto> list();
}
