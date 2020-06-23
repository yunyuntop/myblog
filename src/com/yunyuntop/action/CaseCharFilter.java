package com.yunyuntop.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class CaseCharFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		if (request.getRequestURI().contains("admin")) {
			chain.doFilter(request, response);
			return;
		}

		chain.doFilter(new MyRequest(request), response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}

class MyRequest extends HttpServletRequestWrapper {

	HttpServletRequest request;

	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	/*private String changeChar(String name, String con) {

		String[] array = null;
		for (int n = 0; n < name.length(); n++) {
			if (array == null) {
				array = new String[name.length()];
			}
			array[n] = new Character(name.charAt(n)).toString();
		}
		for (int n = 0; n < array.length; n++) {
			if (con.equals(array[n])) {
				if (" ".equals(con)) {
					array[n] = "&nbsp;";
				} else if (">".equals(con)) {
					array[n] = "&gt;";
				} else if ("<".equals(con)) {
					array[n] = "&lt;";
				} else if ("\n".equals(con)) {
					array[n] = "<br/>";
				}
			}
		}
		String str = "";
		for (int n = 0; n < array.length; n++) {
			str = str + array[n];
		}
		return str;
	}

//	private boolean isEmojiCharacter(char codePoint) {
//		return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
//				|| ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
//				|| ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
//	}*/

	@Override
	public String getParameter(String name) {

		if (request.getMethod().equalsIgnoreCase("get")) {
			String name2 = request.getParameter(name);
			String n = null;
			try {
				if (name2 != null) {
					n = new String(name2.getBytes("ISO-8859-1"), "UTF-8");
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return n;
		} else if (request.getMethod().equalsIgnoreCase("post")) {

			String name0 = null;
			try {
				request.setCharacterEncoding("utf-8");
				if (name != null) {
					name0 = request.getParameter(name);
					if (name0 != null) {
						name0=name0.replaceAll(" " , "&nbsp;");
						name0=name0.replaceAll(">" , "&gt;");
						name0=name0.replaceAll("<" , "&lt;");
						name0=name0.replaceAll("\n" , "<br/>");
						/*for (int j = 0; j < name0.length(); j++) {
							
								if (name0.charAt(j)==' ') {
									name0 = this.changeChar(name0, " ");
								}else
								if (name0.charAt(j)=='>') {
									name0 = this.changeChar(name0, ">");
								}else
								if (name0.charAt(j)=='<') {
									name0 = this.changeChar(name0, "<");
								}else
								if (name0.charAt(j)=='\n') {
									name0 = this.changeChar(name0, "\n");
								}
							
						}*/
						
					}
				}
				return name0;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

		}
		return super.getParameter(name);
	}

}
