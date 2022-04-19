package com.bilitech.yilimusic.vo;

import com.bilitech.yilimusic.enums.GeneralStatus;
import lombok.Data;

import java.util.List;

@Data
public class AlbumVo extends BaseVo {
    private String name;

    private String description;

    private FileVo cover;

    private GeneralStatus status;


    private List<ArtistVo> artists;

    private List<MusicVo> musicList;
}
