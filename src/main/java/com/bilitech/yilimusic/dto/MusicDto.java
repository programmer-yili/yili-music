package com.bilitech.yilimusic.dto;

import com.bilitech.yilimusic.enums.MusicStatus;
import lombok.Data;

import java.util.Date;

@Data
public class MusicDto {
    private String id;

    private String name;

    private MusicStatus status;

    private String description;

    private Date createdTime;

    private Date updatedTime;
}
