package kh.mclass.ttt.sub;

import org.springframework.stereotype.Component;

@Component("testService")
public class TestService {
	public String method1() {
		return "서비스 리턴값";
	}
	
}
