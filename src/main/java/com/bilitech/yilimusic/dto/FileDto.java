package com.bilitech.yilimusic.dto;

import com.bilitech.yilimusic.enums.FileStatus;
import com.bilitech.yilimusic.enums.FileType;
import com.bilitech.yilimusic.enums.Storage;
import lombok.Data;

import java.util.Date;

@Data
public class FileDto {
    private String id;

    private String name;

    private String key;

    private String ext;

    private Integer size;

    private FileType type;

    private Storage storage;

    private FileStatus status;

    private Date createdTime;

    private Date updatedTime;
}
