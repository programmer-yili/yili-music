package com.bilitech.yilimusic.music.entity;

import com.bilitech.yilimusic.core.entity.File;
import com.bilitech.yilimusic.core.entity.TraceableBaseEntity;
import com.bilitech.yilimusic.core.enums.GeneralStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Album extends TraceableBaseEntity {
    private String name;

    private String description;

    private GeneralStatus status;

    private Boolean recommended = false;

    private Integer recommendFactor = 0;

    @OneToOne
    private File cover;

    @ManyToMany
    @JoinTable(name = "album_artist", joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
    private List<Artist> artists;

    @ManyToMany
    @JoinTable(name = "album_music", joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private List<Music> musicList;
}
