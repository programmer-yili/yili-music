package com.bilitech.yilimusic.music.entity;

import com.bilitech.yilimusic.core.entity.File;
import com.bilitech.yilimusic.core.entity.TraceableBaseEntity;
import com.bilitech.yilimusic.music.enums.PlayListStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Playlist extends TraceableBaseEntity {
    private String name;

    private String description;
    @OneToOne
    private File cover;

    @Enumerated(EnumType.STRING)
    private PlayListStatus status = PlayListStatus.DRAFT;


    @ManyToMany
    @JoinTable(name = "playlist_music", joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private List<Music> musicList;

    private Boolean recommended = false;

    private Integer recommendFactor = 0;

    private Boolean special = false;
}
