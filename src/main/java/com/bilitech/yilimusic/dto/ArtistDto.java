package com.bilitech.yilimusic.dto;

import com.bilitech.yilimusic.enums.ArtistStatus;
import lombok.Data;

import java.util.List;

@Data
public class ArtistDto extends TraceableBaseDto {
    private String name;

    private String remark;

    private FileDto photo;

    private List<MusicDto> musicDtoList;

    private ArtistStatus status;

    private Boolean recommended;

    private Integer recommendFactor;
}
