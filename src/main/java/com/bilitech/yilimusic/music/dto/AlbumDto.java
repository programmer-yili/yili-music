package com.bilitech.yilimusic.music.dto;

import com.bilitech.yilimusic.core.dto.FileDto;
import com.bilitech.yilimusic.core.dto.TraceableBaseDto;
import com.bilitech.yilimusic.core.enums.GeneralStatus;
import lombok.Data;

import java.util.List;


@Data
public class AlbumDto extends TraceableBaseDto {
    private String name;

    private String description;

    private FileDto cover;

    private GeneralStatus status;

    private Boolean recommended;

    private Integer recommendFactor;

    private List<ArtistDto> artists;

    private List<MusicDto> musicList;


}
