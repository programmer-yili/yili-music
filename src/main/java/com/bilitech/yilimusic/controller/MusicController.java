package com.bilitech.yilimusic.controller;

import com.bilitech.yilimusic.dto.MusicCreateRequest;
import com.bilitech.yilimusic.dto.MusicSearchFilter;
import com.bilitech.yilimusic.dto.MusicUpdateRequest;
import com.bilitech.yilimusic.mapper.MusicMapper;
import com.bilitech.yilimusic.service.MusicService;
import com.bilitech.yilimusic.vo.MusicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musics")
public class MusicController {

    private MusicService musicService;

    private MusicMapper musicMapper;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MusicVo create(@Validated @RequestBody MusicCreateRequest musicCreateRequest) {
        return musicMapper.toVo(musicService.create(musicMapper.toDto(musicCreateRequest)));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MusicVo update(@PathVariable String id, @Validated @RequestBody MusicUpdateRequest musicUpdateRequest) {
        return musicMapper.toVo(musicService.update(id, musicMapper.toDto(musicUpdateRequest)));
    }


    // Todo: post请求; 参数问题
    @PostMapping("/search")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Page<MusicVo> search(@RequestBody(required = false) MusicSearchFilter searchFilter) {
        return musicService.search(searchFilter).map(musicMapper::toVo);
    }

    @PostMapping("/{id}/publish")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void publish(@PathVariable String id) {
        musicService.publish(id);
    }

    @PostMapping("/{id}/close")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void close(@PathVariable String id) {
        musicService.close(id);
    }

    @Autowired
    public void setMusicService(MusicService musicService) {
        this.musicService = musicService;
    }

    @Autowired
    public void setMusicMapper(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }
}
