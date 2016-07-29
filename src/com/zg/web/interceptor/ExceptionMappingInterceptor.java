package com.zg.web.interceptor;

import java.util.List;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.config.entities.ExceptionMappingConfig;


public class ExceptionMappingInterceptor extends com.opensymphony.xwork2.interceptor.ExceptionMappingInterceptor{
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		 String result;

	        try {
	            result = invocation.invoke();
	        } catch (Exception e) {
	            if (isLogEnabled()) {
	                handleLogging(e);
	            }
	            List<ExceptionMappingConfig> exceptionMappings = invocation.getProxy().getConfig().getExceptionMappings();
	            String mappedResult = this.findResultFromExceptions(exceptionMappings, e);
	            //找到exceptionMessage参数
	            String exceptionMessage=this.findParamFromExceptions(exceptionMappings, e);
	            if (mappedResult != null) {
	                result = mappedResult;
	                //ExceptionHolder中要包含exceptionMessage
	                publishException(invocation, new ExceptionHolder(e,exceptionMessage));
	            } else {
	                throw e;
	            }
	        }

	        return result;
	}
	
    protected String findParamFromExceptions(List<ExceptionMappingConfig> exceptionMappings, Throwable t) {
        String param = null;
        if (exceptionMappings != null) {
            int deepest = Integer.MAX_VALUE;
            for (Object exceptionMapping : exceptionMappings) {
                ExceptionMappingConfig exceptionMappingConfig = (ExceptionMappingConfig) exceptionMapping;
                int depth = getDepth(exceptionMappingConfig.getExceptionClassName(), t);
                if (depth >= 0 && depth < deepest) {
                    deepest = depth;
                    param = exceptionMappingConfig.getParams().get("exceptionMessage");
                }
            }
        }
        return param;
    }

}
