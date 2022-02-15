package com.bilitech.yilimusic.entity;

import com.bilitech.yilimusic.enums.FileStatus;
import com.bilitech.yilimusic.enums.FileType;
import com.bilitech.yilimusic.enums.Storage;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class File extends AbstractEntity {
    private String name;

    private String key;

    private String ext;

    private Integer size;

    @Enumerated(EnumType.STRING)
    private FileType type;

    @Enumerated(EnumType.STRING)
    private Storage storage;

    @Enumerated(EnumType.STRING)
    private FileStatus status = FileStatus.UPLOADING;
}
