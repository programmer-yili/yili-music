package com.bilitech.yilimusic.repository;

import com.bilitech.yilimusic.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, String> {
}
