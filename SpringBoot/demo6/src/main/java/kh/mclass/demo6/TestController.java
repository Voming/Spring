package kh.mclass.demo6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@GetMapping("/my/test1")
	public String test1() {
		return "test1";
	}
}
