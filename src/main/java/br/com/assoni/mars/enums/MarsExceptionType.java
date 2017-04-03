package br.com.assoni.mars.enums;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public enum MarsExceptionType {
	EMPTY_COMMAND,
	INVALID_LOCATION,
	INVALID_COMMAND;
	
	private static final ResourceBundle MARS_BUNDLE = ResourceBundle.getBundle("mars-error"); 

	public String getMessage() {
		return MARS_BUNDLE.getString(name());
	}
	
	public String getMessage(Object[] messageParameters){
		return MessageFormat.format(getMessage(), messageParameters);
	}
}