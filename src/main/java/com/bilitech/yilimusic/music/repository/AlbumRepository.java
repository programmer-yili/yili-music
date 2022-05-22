package com.bilitech.yilimusic.music.repository;

import com.bilitech.yilimusic.music.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface AlbumRepository extends JpaRepository<Album, String>, JpaSpecificationExecutor<Album> {
}
