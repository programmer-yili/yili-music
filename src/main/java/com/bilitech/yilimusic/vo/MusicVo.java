package com.bilitech.yilimusic.vo;

import com.bilitech.yilimusic.enums.MusicStatus;
import lombok.Data;

@Data
public class MusicVo extends BaseVo {

    private String name;

    private MusicStatus status;

    private String description;

    private FileVo file;
}
