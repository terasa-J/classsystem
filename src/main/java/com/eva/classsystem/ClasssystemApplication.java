package com.eva.classsystem;

import com.eva.classsystem.utils.TokenThread;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.eva.classsystem.mapper")

public class ClasssystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClasssystemApplication.class, args);
		//微信端调试  accessToken 先保留在本地超过有效时间再重新获取
		Thread thread = new Thread(new TokenThread());
		thread.start();




	}

}
