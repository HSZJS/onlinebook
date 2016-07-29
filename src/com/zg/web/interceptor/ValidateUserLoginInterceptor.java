package com.zg.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zg.po.User;

public class ValidateUserLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> sessionAttr = invocation.getInvocationContext()
				.getSession();

		User user = (User) sessionAttr.get("user");
		if (user != null) {
			return invocation.invoke();
		} else {
			return Action.LOGIN;
		}
	}

}
