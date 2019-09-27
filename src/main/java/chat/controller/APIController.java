package chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="/messages/{id:.+}",method=RequestMethod.GET)
	public Message getMessagOne(@PathVariable("id")String messageId) {
		return messageMapper.selectOne(messageId);
	}
	
	@RequestMapping(value="/messages",method=RequestMethod.POST)
	public String postMessageOne(@RequestBody Message message) {
		int num =messageMapper.postMessageOne(message);
		if(num==0) {
			return "error\n";
		}else {
			return "Insert OK\n";
		}
	}
	
	@RequestMapping(value="/messages",method=RequestMethod.PUT)
	public String putMessage(@RequestBody Message message) {
		int num = messageMapper.putMessage(message);
		if(num==0) {
			return "error\n";
		}else {
			return "Put OK\n";
		}
	}
	
	@RequestMapping(value="/messages/{id:.+}",method=RequestMethod.DELETE)
	public String deleteMessageOne(@PathVariable("id")String messageId) {
		int num = messageMapper.deleteMessageOne(messageId);
		if(num==0) {
			return "error\n";
		}else {
			return "delete OK\n";
		}
	}
}
