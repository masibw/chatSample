package chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import chat.mapper.MessageMapper;
import chat.model.Message;



@Controller
public class MessageController {

	
	@Autowired
	MessageMapper messageMapper;
	
	@MessageMapping("/message")
	@SendTo("/topic/messages")
	public Message sendMessage(@Payload Message message) {
		messageMapper.insert(message);
		return message;
	}
}
