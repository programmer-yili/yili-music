package com.bilitech.yilimusic.vo;

import com.bilitech.yilimusic.enums.PlayListStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PlaylistVo extends BaseVo {
    private String id;

    private String name;

    private String description;

    private FileVo cover;

    private PlayListStatus status;

    private UserVo creator;

    private List<MusicVo> musicList;

    private Date createdTime;

    private Date updatedTime;
}
