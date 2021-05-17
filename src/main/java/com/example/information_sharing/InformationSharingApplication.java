package com.example.information_sharing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.information_sharing.dao")
public class InformationSharingApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformationSharingApplication.class, args);
	}

}
