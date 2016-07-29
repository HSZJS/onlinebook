package com.zg.web.action;


import java.util.Map;


import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware, ServletContextAware, RequestAware, SessionAware,
		ApplicationAware, ModelDriven {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletContext servletContext;
	private Map requestScope;
	private Map sessionScope;
	private Map applicationScope;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

	public void setRequest(Map<String, Object> requestScope) {
		this.requestScope = requestScope;

	}

	public void setSession(Map<String, Object> sessionScope) {
		this.sessionScope = sessionScope;

	}

	public void setApplication(Map<String, Object> applicationScope) {
		this.applicationScope = applicationScope;

	}

	public Object getModel() {
		return null;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public Map getRequestScope() {
		return requestScope;
	}

	public Map getSessionScope() {
		return sessionScope;
	}

	public Map getApplicationScope() {
		return applicationScope;
	}

}
