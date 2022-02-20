package com.bilitech.yilimusic.vo;

import lombok.Data;

@Data
public class FileUploadVo {
    private String secretId;

    private String secretKey;

    private String sessionToken;

    private String key;

    private String fileId;

    private String bucket;

    private String region;

    private Long startTime;

    private Long expiredTime;
}
