package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
public class SpringCloudEurekaClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaClient2Application.class, args);
	}

}
