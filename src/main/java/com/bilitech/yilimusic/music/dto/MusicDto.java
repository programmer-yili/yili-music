package com.bilitech.yilimusic.music.dto;

import com.bilitech.yilimusic.core.dto.BaseDto;
import com.bilitech.yilimusic.core.dto.FileDto;
import com.bilitech.yilimusic.music.enums.MusicStatus;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class MusicDto extends BaseDto {
    private String name;

    private MusicStatus status = MusicStatus.DRAFT;

    private String description;

    private FileDto file;

    private List<ArtistDto> artistList;
}
