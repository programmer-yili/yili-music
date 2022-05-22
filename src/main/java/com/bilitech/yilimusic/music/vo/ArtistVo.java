package com.bilitech.yilimusic.music.vo;

import com.bilitech.yilimusic.core.enums.GeneralStatus;
import com.bilitech.yilimusic.core.vo.BaseVo;
import com.bilitech.yilimusic.core.vo.FileVo;
import lombok.Data;

import java.util.List;

@Data
public class ArtistVo extends BaseVo {
    private String name;

    private String remark;

    private FileVo photo;

    private List<MusicVo> musicDtoList;

    private GeneralStatus status;

    private Boolean recommended;

    private Integer recommendFactor;
}
