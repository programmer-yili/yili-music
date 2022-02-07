package com.bilitech.yilimusic.vo;

import com.bilitech.yilimusic.enums.MusicStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MusicVo {
    private String id;

    private String name;

    private MusicStatus status;

    private String description;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private Date createdTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private Date updatedTime;
}
