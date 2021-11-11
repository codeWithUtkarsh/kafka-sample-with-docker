package com.codeWithUtkarsh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithUtkarsh.producer.KafkaSender;
import com.codeWithUtkarsh.repo.CartMessageRepository;
import com.codeWithUtkarsh.repo.PaymentMessageRepository;

@RestController
@RequestMapping(value = "/codeWithUtkarsh/")
public class ApacheKafkaWebController {

	@Autowired
	private KafkaSender kafkaSender; //producer
	
	@Autowired
	private PaymentMessageRepository messageRepository;
	
	@Autowired
	private CartMessageRepository creditMessRepository;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		kafkaSender.send(message);

		return "Message sent Successfully";
	}
	
	//Read all messages
    @GetMapping("/getAllMessagesPayment")
    public String getAllMessagesPayment() {
       return messageRepository.getAllMessages() ;
    }
    
    @GetMapping("/getAllMessagesCart")
    public String getAllMessagesCart() {
       return creditMessRepository.getAllMessages() ;
    }

}
