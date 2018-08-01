package org.shafi.rest.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.shafi.rest.messenger.database.DatabaseClass;
import org.shafi.rest.messenger.exception.DataNotFoundException;
import org.shafi.rest.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		Message m1 = new Message(1, "Hello World", "Shafi");
		Message m2 = new Message(2, "Hello Jersey", "Shafi");
		messages.put(m1.getId(), m1);
		messages.put(m2.getId(), m2);
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		ArrayList<Message> messageForYear = new ArrayList<Message>();
		for(Message message : messages.values()) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(message.getCreated());
			int foundYear = cal.get(Calendar.YEAR);
			if(foundYear == year) {
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> messagePaginated = new ArrayList<Message>(messages.values());
		return messagePaginated.subList(start, start+size);
	}
	
	public Message getMessage(long id) {
		Message message = messages.get(id);
		if(message == null) {
			throw new DataNotFoundException("The data with ID: " + id + " is not found");
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
		
	}
	
}
