package com.bilitech.yilimusic.music.vo;

import com.bilitech.yilimusic.core.enums.GeneralStatus;
import com.bilitech.yilimusic.core.vo.BaseVo;
import com.bilitech.yilimusic.core.vo.FileVo;
import lombok.Data;

import java.util.List;

@Data
public class AlbumVo extends BaseVo {
    private String name;

    private String description;

    private FileVo cover;

    private GeneralStatus status;

    private Boolean recommended;

    private Integer recommendFactor;

    private List<ArtistVo> artists;

    private List<MusicVo> musicList;
}
