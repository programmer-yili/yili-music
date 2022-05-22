package com.bilitech.yilimusic.core.vo;

import com.bilitech.yilimusic.core.enums.FileStatus;
import com.bilitech.yilimusic.core.enums.FileType;
import com.bilitech.yilimusic.core.enums.Storage;
import lombok.Data;

@Data
public class FileVo extends BaseVo {
    private String name;

    private String key;

    private String uri;

    private Storage storage;

    private String ext;

    private Long size;

    private FileType type;

    private FileStatus status;
}
