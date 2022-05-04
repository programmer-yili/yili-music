package com.bilitech.yilimusic.dto;

import com.bilitech.yilimusic.enums.GeneralStatus;
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
