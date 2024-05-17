package kh.mclass.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DemoController {
	@GetMapping("/main")
	public String mainMethod(){
		System.out.println();
		
		return "aaa";
	}

}
