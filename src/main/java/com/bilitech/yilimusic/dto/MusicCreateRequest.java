package com.bilitech.yilimusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MusicCreateRequest {
    
    @NotBlank(message = "歌曲名不能为空")
    private String name;

    private String description;
}
