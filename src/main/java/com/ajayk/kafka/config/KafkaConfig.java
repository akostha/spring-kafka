package com.ajayk.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.util.backoff.FixedBackOff;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class KafkaConfig {

	@Bean
	java.util.function.Consumer<String> log() {
	    return str -> {
	        log.info("recieved a string message : " + str);
	    };
	}
	
	@Bean
	public SeekToCurrentErrorHandler errorHandler(KafkaOperations<Object, Object> template) {
		return new SeekToCurrentErrorHandler(
				new DeadLetterPublishingRecoverer(template), new FixedBackOff(1000L, 2));
	}

	@Bean
	public RecordMessageConverter converter() {
		return new StringJsonMessageConverter();
	}
	
	@Bean
	public NewTopic topic() {
		return new NewTopic("video-event", 1, (short) 1);
	}

	@Bean
	public NewTopic chatMessage() {
		return new NewTopic("chat-message", 1, (short) 1);
	}
	
	@Bean
	public NewTopic dlt() {
		return new NewTopic("video-event.DLT", 1, (short) 1);
	}
	
	
	@Bean
	@Profile("default") // Don't run from test(s)
	public ApplicationRunner runner() {
		return args -> {
			System.out.println("Hit Enter to terminate...");
			System.in.read();
		};
	}
}
