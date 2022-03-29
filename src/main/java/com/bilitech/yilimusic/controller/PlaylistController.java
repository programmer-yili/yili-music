package com.bilitech.yilimusic.controller;

import com.bilitech.yilimusic.dto.PlaylistCreateRequest;
import com.bilitech.yilimusic.dto.PlaylistSearchFilter;
import com.bilitech.yilimusic.dto.RecommendRequest;
import com.bilitech.yilimusic.mapper.PlaylistMapper;
import com.bilitech.yilimusic.service.PlaylistService;
import com.bilitech.yilimusic.vo.PlaylistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private PlaylistService playlistService;

    private PlaylistMapper playlistMapper;


    @GetMapping("/{id}")
    public PlaylistVo get(@PathVariable String id) {
        return playlistMapper.toVo(playlistService.get(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PlaylistVo create(@Validated @RequestBody PlaylistCreateRequest playlistCreateRequest) {
        return playlistMapper.toVo(playlistService.create(playlistMapper.toDto(playlistCreateRequest)));
    }

    @GetMapping
    public Page<PlaylistVo> search(@Validated PlaylistSearchFilter playlistSearchFilter) {
        return playlistService.search(playlistSearchFilter).map(playlistMapper::toVo);
    }


    @PostMapping("/{id}/recommend")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PlaylistVo recommend(@PathVariable String id, @Validated @RequestBody RecommendRequest recommendRequest) {
        return playlistMapper.toVo(playlistService.recommend(id, recommendRequest.getRecommendFactor()));
    }

    @PostMapping("/{id}/cancel_recommendation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PlaylistVo cancelRecommendation(@PathVariable String id) {
        return playlistMapper.toVo(playlistService.cancelRecommendation(id));
    }

    @PostMapping("/{id}/make_special")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PlaylistVo makeSpecial(@PathVariable String id) {
        return playlistMapper.toVo(playlistService.makeSpecial(id));
    }

    @PostMapping("/{id}/cancel_special")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PlaylistVo cancelSpecial(@PathVariable String id) {
        return playlistMapper.toVo(playlistService.cancelSpecial(id));
    }

    @Autowired
    public void setPlaylistMapper(PlaylistMapper playlistMapper) {
        this.playlistMapper = playlistMapper;
    }

    @Autowired
    public void setPlaylistService(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
}
