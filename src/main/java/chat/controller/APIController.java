package chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import chat.mapper.MessageMapper;
import chat.model.Message;

@RestController
@RequestMapping(value="api")
public class APIController {

	@Autowired
	MessageMapper messageMapper;
	
	@RequestMapping(value="/messages",method=RequestMethod.GET)
	public List<Message> getMessagesAll(){
		
		List<Message> messages=messageMapper.selectAll();
		return messages;
	}
}
