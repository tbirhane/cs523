package com.miu.KafkaProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.miu.KafkaProject.UserDetail;
import com.miu.KafkaProject.sendReceiveMessage.MessageProducer;

@RestController
@RequestMapping("/kafka")
public class UserController {

	@Autowired
	private MessageProducer messageProducer;
	@PostMapping("/user")
	public ResponseEntity<Object> saveUserDetails(@RequestBody UserDetail userDetails){
		messageProducer.sendMessageToKafka(userDetails);
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}
}
