package chat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import chat.model.Message;
@Mapper
public interface MessageMapper {
	List<Message> selectAll();
	int postMessageOne(Message message);
	Message selectOne(String id);
	int putMessage(Message message);
	int deleteMessageOne(String id);
}
