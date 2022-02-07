package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.dto.MusicCreateRequest;
import com.bilitech.yilimusic.dto.MusicDto;
import com.bilitech.yilimusic.dto.MusicUpdateRequest;

import java.util.List;

public interface MusicService {
    MusicDto create(MusicCreateRequest musicCreateRequest);

    MusicDto update(String id, MusicUpdateRequest musicUpdateRequest);

    List<MusicDto> list();

    void publish(String id);

    void close(String id);
}
