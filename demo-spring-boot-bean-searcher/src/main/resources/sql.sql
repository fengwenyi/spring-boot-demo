-- ----------------------------
-- 用户表
-- ----------------------------
CREATE TABLE `t_user`
(
    `id`               BIGINT(20)   NOT NULL COMMENT '主键ID',
    `create_date_time` DATETIME     NOT NULL COMMENT '创建时间',
    `create_user_id`   BIGINT(20) COMMENT '创建者ID',
    `create_user_name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '创建者名字',
    `update_date_time` DATETIME COMMENT '更新时间',
    `update_user_id`   BIGINT(20) COMMENT '更新者ID',
    `update_user_name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '更新者名字',

    `enabled_state`    TINYINT(1) DEFAULT 0 COMMENT '启用状态：0-不启用；1-启用',
    `deleted_state`     TINYINT(1) DEFAULT 0 COMMENT '逻辑删除状态：0-不删除；1-删除',

    `erwin_id`         VARCHAR(255) NOT NULL COMMENT 'Erwin ID（邮箱）',
    `password`         VARCHAR(255) NOT NULL COMMENT '密码',
    `phone`            VARCHAR(20)           COMMENT '手机号',
    `nickname`         VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '昵称',
    `sex`              TINYINT(1) COMMENT '性别：0-未知；1-男；2-女',
    `avatar`           VARCHAR(255) COMMENT '头像',

    `locked_state`     TINYINT(1) DEFAULT 0 COMMENT '锁定状态：0-正常；1-锁定',

    PRIMARY KEY (`id`),
    UNIQUE KEY `uni_erwin_id` (`erwin_id`),
    UNIQUE KEY `uni_phone` (`phone`)

) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT '用户表';

-- ----------------------------
-- 角色表
-- ----------------------------
CREATE TABLE `t_role`
(
    `id`               BIGINT(20)                                             NOT NULL COMMENT '主键ID',
    `create_date_time` DATETIME                                               NOT NULL COMMENT '创建时间',
    `create_user_id`   BIGINT(20) COMMENT '创建者ID',
    `create_user_name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '创建者名字',
    `update_date_time` DATETIME COMMENT '更新时间',
    `update_user_id`   BIGINT(20) COMMENT '更新者ID',
    `update_user_name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '更新者名字',

    `enabled_state`    TINYINT(1) DEFAULT 0 COMMENT '启用状态：0-不启用；1-启用',
    `deleted_state`     TINYINT(1) DEFAULT 0 COMMENT '逻辑删除状态：0-不删除；1-删除',

    `role_code`        VARCHAR(255)                                           NOT NULL COMMENT '角色编码',
    `role_name`        VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色名称',

    PRIMARY KEY (`id`),

    UNIQUE KEY `uni_role_code` (`role_code`) -- 角色编码不重复

) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT '角色表';

-- ----------------------------
-- 用户-角色表
-- ----------------------------
CREATE TABLE `t_user_role`
(
    `id`               BIGINT(20) NOT NULL COMMENT '主键ID',
    `create_date_time` DATETIME   NOT NULL COMMENT '创建时间',
    `create_user_id`   BIGINT(20) COMMENT '创建者ID',
    `create_user_name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '创建者名字',
    `update_date_time` DATETIME COMMENT '更新时间',
    `update_user_id`   BIGINT(20) COMMENT '更新者ID',
    `update_user_name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '更新者名字',

    `enabled_state`    TINYINT(1) DEFAULT 0 COMMENT '启用状态：0-不启用；1-启用',
    `deleted_state`     TINYINT(1) DEFAULT 0 COMMENT '逻辑删除状态：0-不删除；1-删除',

    `user_id`          BIGINT(20) NOT NULL COMMENT '用户ID',
    `role_id`          BIGINT(20) NOT NULL COMMENT '角色ID',

    PRIMARY KEY (`id`)

) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT '用户-角色表';