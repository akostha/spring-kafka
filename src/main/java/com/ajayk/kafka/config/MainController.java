package com.ajayk.kafka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	private Producer producer;

	@PostMapping(path = "/sendMsg/{what}")
	public void sendMessage(@PathVariable String what) {
		producer.sendMessage(what);
	}
}
