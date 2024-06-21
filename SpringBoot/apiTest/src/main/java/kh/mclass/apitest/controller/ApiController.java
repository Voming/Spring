package kh.mclass.apitest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import kh.mclass.apitest.domain.HospitalEntity;
import kh.mclass.apitest.service.ApiService;

@Controller
public class ApiController {
	@Autowired
	ApiService apiService;

	@GetMapping("/home")
	public String index() {
		return "demo project!!";
	}

	@GetMapping("/front")
	public String front() {
		return "views/front";
	}

	@GetMapping("/back")
	public String home(Model model) throws IOException {
		List<HospitalEntity> hospitalList = apiService.getApi();
		model.addAttribute("hospitalList", hospitalList);
		String result = apiService.getApi3();
		model.addAttribute("result", result);
		return "views/test";
	}

	@ExceptionHandler(IOException.class)
	public String exceptionHandler(IOException e) {
		e.printStackTrace();
		return "redirect:/home";
	}
}
