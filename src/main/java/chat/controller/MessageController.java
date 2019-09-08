package chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import chat.model.Message;



@Controller
public class MessageController {

	
	@MessageMapping("/message")
	@SendTo("/topic/messages")
	public Message sendMessage(@Payload Message message) {
		return message;
	}
}
