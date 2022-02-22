package com.bilitech.yilimusic.dto;

import com.bilitech.yilimusic.enums.PlayListStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PlaylistDto {
    private String id;

    private String name;

    private String description;

    private FileDto cover;

    private PlayListStatus status;

    private UserDto creator;

    private List<MusicDto> musicList;

    private Date createdTime;

    private Date updatedTime;
}
