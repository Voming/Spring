package kh.mclass.apitest2;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class TestController {
	@Autowired
	TestService testService;
	
	@GetMapping("/")
	public String ttt(Model model) {
		model.addAttribute("result", testService.getApi());
		return "ttt";
	}
	
}
