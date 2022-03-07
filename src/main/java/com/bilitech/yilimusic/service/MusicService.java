package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.dto.MusicDto;
import com.bilitech.yilimusic.entity.Music;

public interface MusicService extends GeneralService<Music, MusicDto> {

    void publish(String id);

    void close(String id);
}
