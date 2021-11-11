package com.codeWithUtkarsh.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.codeWithUtkarsh.repo.CartMessageRepository;
import com.codeWithUtkarsh.repo.PaymentMessageRepository;

@Component
public class KafkaConsumer {

      private Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

      @Autowired
      private PaymentMessageRepository messageRepo;
      
      @Autowired
      private CartMessageRepository cartMessageRepository;

      @KafkaListener(topics = "${myapp.kafka.topic.payment}", groupId = "xyz")
      public void consumePayment(String message) {
         log.info("MESSAGE RECEIVED AT CONSUMER END -> " + message);
         messageRepo.addMessage(message);
      }
      
      @KafkaListener(topics = "${myapp.kafka.topic.cart}", groupId = "xyz")
      public void consumeCart(String message) {
         log.info("MESSAGE RECEIVED AT CONSUMER END -> " + message);
         cartMessageRepository.addMessage(message);
      }
}
