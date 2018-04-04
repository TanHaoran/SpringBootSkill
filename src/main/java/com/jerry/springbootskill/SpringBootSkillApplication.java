package com.jerry.springbootskill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.jerry.springbootskill.mapper")
@EnableScheduling
@EnableAsync
public class SpringBootSkillApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSkillApplication.class, args);
	}
}
