package com.bilitech.yilimusic.music.vo;

import com.bilitech.yilimusic.core.vo.BaseVo;
import com.bilitech.yilimusic.core.vo.FileVo;
import com.bilitech.yilimusic.music.enums.MusicStatus;
import lombok.Data;

import java.util.List;

@Data
public class MusicVo extends BaseVo {

    private String name;

    private MusicStatus status;

    private String description;

    private FileVo file;

    private List<ArtistVo> artistList;
}
