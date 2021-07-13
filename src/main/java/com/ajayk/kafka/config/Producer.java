package com.ajayk.kafka.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Producer {

	@Autowired
	private KafkaTemplate<Object, Object> template;

	public void sendMessage(String what) {
		ChatMessage cMessage  = new ChatMessage(what, Instant.now().getEpochSecond());		
		this.template.send("chat-message", cMessage);
	}
}
