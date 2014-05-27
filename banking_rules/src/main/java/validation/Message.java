package validation;

import java.util.List;

public interface Message {
	
	public enum Type {
		ERROR, WARNING
	}
	
	Type getType();
	
	List<Object> getContextOrdered();
	
	public String getMesageKey();

}
