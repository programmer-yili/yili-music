package com.bilitech.yilimusic.dto;

import com.bilitech.yilimusic.enums.ArtistStatus;
import lombok.Data;

import java.util.List;

@Data
public class ArtistDto extends BaseDto {
    private String name;

    private String remark;

    private FileDto photo;

    private List<MusicDto> musicDtoList;

    private ArtistStatus status;
}
