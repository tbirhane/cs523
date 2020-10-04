package com.miu.KafkaProject.sendReceiveMessage;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;


import com.miu.KafkaProject.UserDetail;

@Service
public class MessageConsumer {

	@KafkaListener(topics = "CS523_TOPIC", 
			groupId = "group-id", 
			containerFactory = "userKafkaListenerContainerFactory")
	public void consumeUserDetials(UserDetail userDetail) {
		if(userDetail != null) {
			String userD = "id:"+userDetail.getId() +
					" name:"+userDetail.getName() +
					" titile:"+userDetail.getTitle() +
					" salary:"+userDetail.getTitle();
			System.out.println("User details");
			System.out.println(userD);
		}
	}
}
