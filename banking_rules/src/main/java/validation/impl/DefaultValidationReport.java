package validation.impl;

import java.util.Set;

import validation.Message;
import validation.Message.Type;
import validation.ValidationReport;

public class DefaultValidationReport implements ValidationReport {

	@Override
	public Set<Message> getMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Message> getMessagesByType(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(String messageKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
