package com.bilitech.yilimusic.music.dto;

import com.bilitech.yilimusic.core.dto.FileDto;
import com.bilitech.yilimusic.core.dto.TraceableBaseDto;
import com.bilitech.yilimusic.core.enums.GeneralStatus;
import lombok.Data;

import java.util.List;

@Data
public class ArtistDto extends TraceableBaseDto {
    private String name;

    private String remark;

    private FileDto photo;

    private List<MusicDto> musicDtoList;

    private GeneralStatus status;

    private Boolean recommended;

    private Integer recommendFactor;
}
