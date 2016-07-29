package com.zg.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

public class PromptResult extends StrutsResultSupport {
	
	private String message;
	private int second=3;
	private String charset="UTF-8";
	
	
	
	public PromptResult() {
		super();
	}

	public PromptResult(String location, boolean parse, boolean encode) {
		super(location, parse, encode);
	}

	public PromptResult(String location) {
		super(location);
	}

	@Override
	protected void doExecute(String finalLocation, ActionInvocation invocation)
			throws Exception {
	
		HttpServletRequest request=(HttpServletRequest) invocation.getInvocationContext().get(HTTP_REQUEST);
		HttpServletResponse response=(HttpServletResponse) invocation.getInvocationContext().get(HTTP_RESPONSE);
		
		response.setContentType("text/html;charset="+charset);
		response.setHeader("refresh", second+";url="+request.getContextPath()+ finalLocation);
		//refresh 3;url=www.baidu.com
		//out.print('±£´æ³É¹¦')
		PrintWriter out=response.getWriter();
		out.print(message);
		out.flush();
		out.close();
		
		
	}

	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public int getSecond() {
		return second;
	}



	public void setSecond(int second) {
		this.second = second;
	}



	public String getCharset() {
		return charset;
	}



	public void setCharset(String charset) {
		this.charset = charset;
	}



	

}
