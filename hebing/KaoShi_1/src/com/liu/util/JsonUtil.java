package com.liu.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	
	private static void print(String json,HttpServletResponse response) {
		PrintWriter out = null;
		try {
			if(null != response) {
				out = response.getWriter();
				out.print(json);
				out.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
		}
	}
	
	public static void write(Object info,HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		String json = JSONObject.toJSONString(info);
		//System.out.println(json);
		print(json,response);
	}
}
