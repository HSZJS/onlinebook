package com.zg.web.interceptor;

public class ExceptionHolder extends com.opensymphony.xwork2.interceptor.ExceptionHolder{
	
	private String exceptionMessage;
	

	public ExceptionHolder(Exception exception) {
		super(exception);
	}

	
	

	public ExceptionHolder(Exception exception, String exceptionMessage) {
		super(exception);
		this.exceptionMessage = exceptionMessage;
	}




	public String getExceptionMessage() {
		return exceptionMessage;
	}


	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	
	
}
