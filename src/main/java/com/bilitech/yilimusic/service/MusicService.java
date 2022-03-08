package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.dto.MusicDto;
import com.bilitech.yilimusic.dto.MusicSearchFilter;
import com.bilitech.yilimusic.entity.Music;
import org.springframework.data.domain.Page;

public interface MusicService extends GeneralService<Music, MusicDto> {

    Page<MusicDto> search(MusicSearchFilter musicSearchRequest);

    void publish(String id);

    void close(String id);
}
