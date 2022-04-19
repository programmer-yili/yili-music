CREATE TABLE `album`
    (
        `id` VARCHAR(32) NOT NULL
            PRIMARY KEY COMMENT '专辑ID',
        `name` VARCHAR(64) NOT NULL COMMENT '专辑名字',
        `description` TEXT NULL COMMENT '专辑简介',
        `cover_id` VARCHAR(32) NULL COMMENT '专辑封面ID',
        `status` VARCHAR(32) DEFAULT 'DRAFT' NOT NULL COMMENT '专辑上架状态，DRAFT-草稿，PUBLISHED-已上架，BLOCKED-已封禁',
        `created_by_user_id` VARCHAR(32) NOT NULL COMMENT '创建人ID',
        `updated_by_user_id` VARCHAR(32) NOT NULL COMMENT '最后更新人ID',
        `created_time` datetime(6) NOT NULL COMMENT '创建时间',
        `updated_time` datetime(6) NOT NULL COMMENT '更新时间',
        CONSTRAINT album_cover_id
            FOREIGN KEY (cover_id) REFERENCES `file` (id),
        CONSTRAINT album_created_by_user_id
            FOREIGN KEY (created_by_user_id) REFERENCES `user` (id),
        CONSTRAINT album_updated_by_user_id
            FOREIGN KEY (updated_by_user_id) REFERENCES `user` (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '专辑表';

CREATE TABLE `album_music`
    (
        `album_id` VARCHAR(32) NOT NULL COMMENT '专辑ID',
        `music_id` VARCHAR(32) NOT NULL COMMENT '歌曲ID',
        CONSTRAINT album_music_album_id
            FOREIGN KEY (album_id) REFERENCES `album` (id),
        CONSTRAINT album_music_music_id
            FOREIGN KEY (music_id) REFERENCES `music` (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '专辑歌曲表';


CREATE TABLE `album_artist`
    (
        `album_id` VARCHAR(32) NOT NULL COMMENT '专辑ID',
        `artist_id` VARCHAR(32) NOT NULL COMMENT '歌手ID',
        CONSTRAINT album_artist_album_id
            FOREIGN KEY (album_id) REFERENCES `album` (id),
        CONSTRAINT album_artist_artist_id
            FOREIGN KEY (artist_id) REFERENCES `artist` (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '专辑歌手';