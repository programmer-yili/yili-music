package com.bilitech.yilimusic.repository;

import com.bilitech.yilimusic.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlbumRepository extends JpaRepository<Album, String> {
}
