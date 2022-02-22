CREATE TABLE playlist_music
    (
        `playlist_id` VARCHAR(32) NOT NULL COMMENT '歌单ID',
        `music_id` VARCHAR(32) NOT NULL COMMENT '歌曲ID',
        CONSTRAINT c_playlist_id
            FOREIGN KEY (playlist_id) REFERENCES `playlist` (id),
        CONSTRAINT c_music_id
            FOREIGN KEY (music_id) REFERENCES `music` (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '歌单歌曲表';