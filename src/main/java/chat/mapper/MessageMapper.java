package chat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import chat.model.Message;
@Mapper
public interface MessageMapper {
	List<Message> selectAll();
	void insert(Message message);
}
