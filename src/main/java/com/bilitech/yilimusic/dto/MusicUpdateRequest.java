package com.bilitech.yilimusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class MusicUpdateRequest {
    @NotBlank(message = "歌曲名不能为空")
    private String name;

    private String description;

    private String fileId;

    @NotEmpty(message = "歌手未选择")
    private List<String> artistIds;
}
