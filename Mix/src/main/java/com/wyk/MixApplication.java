package com.wyk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wyk.*.mapper")
public class MixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MixApplication.class, args);
	}
}
