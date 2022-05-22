package com.bilitech.yilimusic.music.service;

import com.bilitech.yilimusic.core.service.GeneralService;
import com.bilitech.yilimusic.music.dto.MusicDto;
import com.bilitech.yilimusic.music.dto.MusicSearchFilter;
import com.bilitech.yilimusic.music.entity.Music;
import org.springframework.data.domain.Page;

public interface MusicService extends GeneralService<Music, MusicDto> {

    Page<MusicDto> search(MusicSearchFilter musicSearchRequest);

    void publish(String id);

    void close(String id);
}
