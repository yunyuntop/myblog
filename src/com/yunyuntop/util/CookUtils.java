package com.yunyuntop.util;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.Cookie;

public class CookUtils {
	/**
	 * 通过名称在cookie数组获取指定的cookie
	 * @param name cookie名称
	 * @param cookies  cookie数组
	 * @return
	 */
	public static Cookie getCookieByName(String name, Cookie[] cookies) {
		if(cookies!=null){
			for (Cookie c : cookies) {
				//通过名称获取
				if(name.equals(c.getName())){
					//返回
					return c;
				}
			}
		}
		return null;
	}
	
	public static List<String> getCookieHistoryLogByName(String name,Cookie[] c){
		List<String> list=new LinkedList<String>();
		if(c!=null){
			for (Cookie cookie : c) {
				if(cookie.getName().contains(name))
				
				
				{
					list.add(cookie.getValue());
				}
			}
		}
		
		return list;
	}
}
