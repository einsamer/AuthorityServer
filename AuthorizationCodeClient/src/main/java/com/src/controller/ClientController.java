package com.src.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ajax")
public class ClientController {

	@RequestMapping("/home")
	public ModelAndView goClientHome() {
		ModelAndView clientHome = new ModelAndView("client-home");
		return clientHome;
	}
}
