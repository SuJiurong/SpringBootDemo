package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data // Lombok 注解，自动生成 getter, setter, toString 等方法
@TableName("user") // 指定实体类对应的数据库表名
public class User {

    @TableId(type = IdType.AUTO) // 声明主键，并设置为主键自增
    private Long id;

    private String name;

    private Integer age;

    private String email;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Integer getAge() {return age;}

    public void setAge(Integer age) {this.age = age;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}