package com.zg.web.interceptor;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class EncodingIntereptor extends AbstractInterceptor {
	/**
	  * Struts2����������
	  */
	 
	 public String intercept(ActionInvocation arg0) throws Exception {
	  // TODO Auto-generated method stub
	   ActionContext actionContext = arg0.getInvocationContext();   
	   HttpServletRequest request= (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST); 
	  System.out.println("Encoding Intercept...");
	  /**
	   * �˷������GET �� POST��������
	   */
	  if( request.getMethod().compareToIgnoreCase("post")>=0){
	      try {
	       request.setCharacterEncoding("utf-8");
	      } catch (UnsupportedEncodingException e) {
	       // TODO Auto-generated catch block
	       e.printStackTrace();
	      }
	     }else{
	      Iterator iter=request.getParameterMap().values().iterator();
	      while(iter.hasNext())
	      {
	       String[] parames=(String[])iter.next();
	       for (int i = 0; i < parames.length; i++) {
	        try {
	         parames[i]=new String(parames[i].getBytes("iso8859-1"),"utf-8");//�˴�GBK��ҳ�����һ��
	        } catch (UnsupportedEncodingException e) {
	         e.printStackTrace();
	        }
	       }   
	      }   
	       }
	         return arg0.invoke();
	 }
}
