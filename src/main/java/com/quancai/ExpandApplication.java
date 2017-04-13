package com.quancai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.quancai.dao")
public class ExpandApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpandApplication.class, args);
	}
}
