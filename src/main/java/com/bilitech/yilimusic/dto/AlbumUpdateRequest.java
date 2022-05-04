package com.bilitech.yilimusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class AlbumUpdateRequest {
    @NotBlank(message = "专辑名字不能为空")
    private String name;

    private String description;

    @NotBlank(message = "专辑封面必须上传")
    private String coverId;

    @NotEmpty(message = "至少选择一名歌手")
    private List<String> artistIds;
}
