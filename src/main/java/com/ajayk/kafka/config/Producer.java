package com.ajayk.kafka.config;

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
		ChatMessage cMessage  = new ChatMessage(what);		
		this.template.send("chat-message",  cMessage.getUserId(), cMessage);
	}

}
