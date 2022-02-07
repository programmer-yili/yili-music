package com.bilitech.yilimusic.entity;

import com.bilitech.yilimusic.enums.MusicStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class Music extends AbstractEntity {
    private String name;
    
    @Enumerated(EnumType.STRING)
    private MusicStatus status;

    private String description;
}
