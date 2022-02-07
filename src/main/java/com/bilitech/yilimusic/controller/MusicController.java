package com.bilitech.yilimusic.controller;

import com.bilitech.yilimusic.dto.MusicCreateRequest;
import com.bilitech.yilimusic.dto.MusicUpdateRequest;
import com.bilitech.yilimusic.mapper.MusicMapper;
import com.bilitech.yilimusic.service.MusicService;
import com.bilitech.yilimusic.vo.MusicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/musics")
public class MusicController {

    private MusicService musicService;

    private MusicMapper musicMapper;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MusicVo create(@Validated @RequestBody MusicCreateRequest musicCreateRequest) {
        return musicMapper.toVo(musicService.create(musicCreateRequest));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MusicVo update(@PathVariable String id, @Validated @RequestBody MusicUpdateRequest musicUpdateRequest) {
        return musicMapper.toVo(musicService.update(id, musicUpdateRequest));
    }


    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<MusicVo> list() {
        return musicService.list().stream().map(musicMapper::toVo).collect(Collectors.toList());
    }

    @PostMapping("/{id}/publish")
    public void publish(@PathVariable String id) {
        musicService.publish(id);
    }

    @PostMapping("/{id}/close")
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
