package chat.model;

import lombok.Getter;
import lombok.Setter;


public class Message {
	@Getter @Setter
	private int id;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String contents;

	public Message(String name, String contents){
		this.name=name;
		this.contents=contents;
	}
	
	
}
