package com.ajayk.kafka.config;

import java.time.Instant;

public class ChatMessage {

	private String userId;
	private String contents;
	private long time;

	public ChatMessage() {

	}

	public ChatMessage(String contents) {

		this.contents = contents;
		this.time = Instant.now().getEpochSecond();
		this.userId = "user"+ this.time%5;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContents() {

		return contents;
	}

	public long getTime() {

		return time;
	}

	public void setTime(long time) {

		this.time = time;
	}

	@Override
	public String toString() {

		return "ChatMessage [contents=" + contents + ", userId=" + userId+ ", time=" + time + "]";
	}

}