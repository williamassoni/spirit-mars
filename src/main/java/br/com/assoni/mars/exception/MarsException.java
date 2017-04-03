package br.com.assoni.mars.exception;

import br.com.assoni.mars.enums.MarsExceptionType;

public class MarsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private MarsExceptionType type;
	
	public MarsException(MarsExceptionType type,Object... parameters) {
		super(type.getMessage(parameters));
		this.type = type;
	}
	
	public MarsExceptionType getType() {
		return type;
	}
}