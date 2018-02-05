package com.eva.classsystem;

import com.eva.classsystem.utils.Utils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@MapperScan("com.eva.classsystem.mapper")

public class ClasssystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClasssystemApplication.class, args);

	}

}
