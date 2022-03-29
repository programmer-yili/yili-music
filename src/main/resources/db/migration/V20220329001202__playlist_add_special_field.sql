ALTER TABLE `playlist`
    ADD COLUMN `special` TINYINT(1) NOT NULL DEFAULT 0  COMMENT '是否特色歌单：特色歌单：1； 否则：0；默认：0'  AFTER `recommended`;