package com.zg.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.GenericValidator;

public class WebUtil {

	/**
	 * �����Ի�����ʾ��Ϣ������ת��ָ����ҳ��
	 * 
	 * @param request
	 * @param response
	 * @param message
	 *            ��Ϣ
	 * @param path
	 *            ��ת·������Թ���·������/��ͷ
	 * @param �Ƿ��Ǹ�������ת
	 * @throws IOException
	 */
	public static void alert(HttpServletRequest request,
			HttpServletResponse response, String message, String path,
			boolean parent) throws IOException { 
		PrintWriter out = null;
		try {
			response.setContentType("text/html");
			out = response.getWriter();
			out.write("<script type='text/javascript'>");
			
			if (parent) {
				out.write("parent.");
			}
			if (GenericValidator.isBlankOrNull(path)) {
				path = request.getHeader("Referer");
				out.write("window.location.href='" + path + "';");
			} else {
				out.write("window.location.href='" + request.getContextPath()
						+ path + "';");
			}
			out.write("</script>");
			out.flush();
		} finally {
			if (out != null)
				out.close();
		}
	}

	public static void print(HttpServletResponse response, String contentType,
			String message) throws IOException {
		String defualtContentType = "text/html";
		contentType = GenericValidator.isBlankOrNull(contentType) ? defualtContentType
				: contentType;
		response.setContentType(contentType);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(message);
			out.flush();

		} finally {
			if (out != null)
				out.close();
		}
	}

}
