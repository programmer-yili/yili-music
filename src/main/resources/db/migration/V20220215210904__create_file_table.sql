CREATE TABLE file
    (
        `id` VARCHAR(32) NOT NULL
            PRIMARY KEY COMMENT '文件ID',
        `name` VARCHAR(64) NOT NULL COMMENT '文件名',
        `file_key` VARCHAR(64) NOT NULL COMMENT '文件hash值，即ObjectKey',
        `ext` VARCHAR(12) NOT NULL COMMENT '文件后缀名',
        `size` INT DEFAULT 0 NOT NULL COMMENT '文件大小；单位byte',
        `type` VARCHAR(32) DEFAULT 'OTHER' NOT NULL COMMENT '文件类型，AUDIO-音频，IMAGE-图片，VIDEO-视频，OTHER-其他',
        `storage` VARCHAR(16) DEFAULT 'COS' NOT NULL COMMENT '存储供应商，COS-腾讯云存储，OSS-阿里云存储',
        `status` VARCHAR(32) DEFAULT 'UPLOADING' NOT NULL COMMENT '文件状态，UPLOADING-上传中，UPLOADED-已上传，CANCEL-已取消',
        `created_time` datetime(6) NOT NULL COMMENT '创建时间',
        `updated_time` datetime(6) NOT NULL COMMENT '更新时间'
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '文件表';