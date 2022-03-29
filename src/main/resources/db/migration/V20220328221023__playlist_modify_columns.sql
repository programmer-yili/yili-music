ALTER TABLE `playlist`
    ADD COLUMN `recommended` TINYINT(1) NOT NULL DEFAULT 0  COMMENT '是否推荐：推荐：1； 不推荐：0；默认：0'  AFTER `status`,
    ADD COLUMN `recommend_factor` INT NOT NULL DEFAULT 0  COMMENT '推荐因数：越高越在上面' AFTER `recommended`;

ALTER TABLE `playlist`
    ADD COLUMN `created_by_user_id` VARCHAR(32) NOT NULL DEFAULT '1'  COMMENT '创建者用户ID' AFTER `status` ,
        ADD CONSTRAINT `playlist_created_by_user_id`
        FOREIGN KEY (`created_by_user_id`) REFERENCES `user`(`id`);

ALTER TABLE `playlist`
    ADD COLUMN `updated_by_user_id` VARCHAR(32) NOT NULL DEFAULT '1' COMMENT '更新者用户ID' AFTER `created_by_user_id` ,
        ADD CONSTRAINT `playlist_updated_by_user_id`
        FOREIGN KEY (`updated_by_user_id`) REFERENCES `user`(`id`);