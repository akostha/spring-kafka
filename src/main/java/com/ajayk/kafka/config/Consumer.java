package com.ajayk.kafka.config;

import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Consumer {
	
	private final TaskExecutor exec = new SimpleAsyncTaskExecutor();

	@KafkaListener(id = "chatGroup", topics = "chat-message")
	public void processMessage(@Payload ChatMessage cMessage) {
		log.info("Received: {}" + cMessage);
		//this.exec.execute(() -> System.out.println("Hit Enter to terminate..."));
	}

}