package com.bilitech.yilimusic.vo;

import com.bilitech.yilimusic.enums.ArtistStatus;
import lombok.Data;

import java.util.List;

@Data
public class ArtistVo extends BaseVo {
    private String name;

    private String remark;

    private FileVo photo;

    private List<MusicVo> musicDtoList;

    private ArtistStatus status;
}
