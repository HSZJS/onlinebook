package com.zg.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.GenericValidator;

public class WebUtil {

	/**
	 * 弹出对话框显示信息，并跳转到指定的页面
	 * 
	 * @param request
	 * @param response
	 * @param message
	 *            信息
	 * @param path
	 *            跳转路径，相对工程路径，以/开头
	 * @param 是否是父窗口跳转
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
