CREATE TABLE user
    (
        id VARCHAR(32) NOT NULL
            PRIMARY KEY COMMENT '用户ID',
        username VARCHAR(64) NOT NULL COMMENT '用户名',
        nickname VARCHAR(64) NULL COMMENT '用户昵称',
        password VARCHAR(64) NOT NULL COMMENT '加密后的密码',
        gender VARCHAR(255) NULL COMMENT '性别',
        locked tinyint(1) DEFAULT 0 NOT NULL COMMENT '是否锁定，1-是，0-否',
        enabled tinyint(1) DEFAULT 1 NOT NULL COMMENT '是否可用，1-是，0-否',
        last_login_ip VARCHAR(64) NULL COMMENT '最后登录IP',
        last_login_time datetime(6) NULL COMMENT '最后登录IP',
        created_time datetime(6) NOT NULL COMMENT '创建时间',
        updated_time datetime(6) NOT NULL COMMENT '更新时间',
        CONSTRAINT uk_user_username
            UNIQUE (username)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '用户表';