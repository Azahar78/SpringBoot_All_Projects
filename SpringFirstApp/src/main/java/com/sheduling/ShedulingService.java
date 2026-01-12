package com.sheduling;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("sos")
public class ShedulingService {

	//@Scheduled(fixedDelay = 2000)
	
	@Scheduled(cron = " */10 * * * * *")
	public void reportGenerate() {
		System.out.println(" Report generate Mehode call :: "+LocalDateTime.now());
	}
	
	void genereport() {
		System.out.println("ffghhhh....");
	}
}
