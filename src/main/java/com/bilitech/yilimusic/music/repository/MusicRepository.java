package com.bilitech.yilimusic.music.repository;

import com.bilitech.yilimusic.music.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, String>, JpaSpecificationExecutor<Music> {
    Optional<Music> findById(String id);
}
