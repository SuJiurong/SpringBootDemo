package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.mapper") // 指定Mapper接口所在的包路径
public class demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(demoApplication.class, args);
	}

}