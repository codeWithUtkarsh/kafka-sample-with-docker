package com.codeWithUtkarsh.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.codeWithUtkarsh.consumer.KafkaConsumer;

@Service
public class KafkaSender {

	private Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${myapp.kafka.topic.payment}")
	private String payment;
	
	@Value("${myapp.kafka.topic.cart}")
	private String cart;

	public void send(String message) {
		log.info("MESSAGE SENT FROM PRODUCER END -> " + message);
		kafkaTemplate.send(payment, message);
		kafkaTemplate.send(cart, message);
	}
}
