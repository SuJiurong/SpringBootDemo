-- 创建数据库（如果不存在）
CREATE DATABASE IF NOT EXISTS mybatis_plus_demo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE mybatis_plus_demo;

-- 创建用户表
CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    `name` VARCHAR(50) NOT NULL COMMENT '姓名',
    `age` INT COMMENT '年龄',
    `email` VARCHAR(100) COMMENT '邮箱',
    `deleted` INT DEFAULT 0 COMMENT '逻辑删除标志（0：未删除，1：已删除）',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

echo "# SpringBootDemo" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:SuJiurong/SpringBootDemo.git
git push -u origin main