package com.boot.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

	@Value("${my-kafka-topic}")
	private String topic;

	@Autowired
	private KafkaTemplate<String, String> template;

	@Scheduled(cron = "*/3 * * * * *")
	public void sendMessage() {

		template.send(topic, "Message from Producer " + LocalDateTime.now().getHour() + ":"
				+ LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond());

	}
}
