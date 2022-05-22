package com.bilitech.yilimusic.music.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PlaylistCreateRequest {
    @NotBlank(message = "歌单名不能为空")
    private String name;

    private String description;

    @NotNull(message = "请上传封面")
    private String coverId;
}
