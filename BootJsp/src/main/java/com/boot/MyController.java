package com.boot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/home")
	public String homePage(Map<String,String> model) {
	//	model.addAttribute("uname","John");
	//	model.addAttribute("date",new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		model.put("uname","Willam");
		model.put("date",new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		
		return"home";
	}
}
