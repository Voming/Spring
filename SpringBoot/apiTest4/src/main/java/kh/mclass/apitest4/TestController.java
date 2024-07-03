package kh.mclass.apitest4;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@RequestMapping(value = "do")
public class TestController {
	public TestController() {
		// TODO Auto-generated constructor stub
		 String serviceKey = "";
		 String url ="";
		 url += "?serviceKey=" + URLEncoder.encode(serviceKey) + "&strSrch=" + URLEncoder.encode("3")  + "&resultType =" + URLEncoder.encode("json");
		 
		 try {
			url +=  URLEncoder.encode("?serviceKey=","UTF-8") + serviceKey;
			url +=  URLEncoder.encode("&strSrch=","UTF-8") + URLEncoder.encode("3","UTF-8");
			url +=  URLEncoder.encode("&resultType=","UTF-8")  + URLEncoder.encode("json","UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
	}

}
