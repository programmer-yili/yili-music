package com.bilitech.yilimusic.music.entity;

import com.bilitech.yilimusic.core.entity.BaseEntity;
import com.bilitech.yilimusic.core.entity.File;
import com.bilitech.yilimusic.music.enums.MusicStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Music extends BaseEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private MusicStatus status;

    @ManyToMany
    @JoinTable(name = "artist_music", joinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
    private List<Artist> artistList;

    private String description;

    @OneToOne
    private File file;
}
