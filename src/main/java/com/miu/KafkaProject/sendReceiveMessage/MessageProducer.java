package com.miu.KafkaProject.sendReceiveMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.miu.KafkaProject.UserDetail;

@Service
public class MessageProducer {

	@Autowired
	private KafkaTemplate<String, UserDetail> kafkaProducer;
	@Value("${kafka.topic}")
	private String kafkaTopic;
	
	public void sendMessageToKafka(UserDetail userDetail) {		
		this.kafkaProducer.send(kafkaTopic, userDetail);
	}
}
