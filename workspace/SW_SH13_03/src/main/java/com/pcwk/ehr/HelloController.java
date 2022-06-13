package com.pcwk.ehr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	
	@RequestMapping(value = "/hello.do")
	public String helloView(Model model) {
		System.out.println("===================");
		System.out.println("=helloView()=");
		System.out.println("===================");
		
		model.addAttribute("name", "full stack dev");
		// prfix++"hello/hello"+suffix
		// WEB-INF/views/hello/hello.jsp
		return "hello/hello";
	}
}