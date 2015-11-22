package com.src.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/anonymous")
public class GeneralController {

	@RequestMapping(value = {"","/home"}, method = RequestMethod.GET)
	public @ResponseBody ModelAndView goHome() {
		ModelAndView homepage = new ModelAndView("homepage");
		String welcome = "Welcome to Spring MVC!";
		homepage.addObject("welcome", welcome);

		return homepage;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		ModelAndView login = new ModelAndView("login");
		login.addObject("greeting", "Thank you for coming!");
		return login;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login() {
		System.out.println("welcome: ");

		return "redirect:/anynomous";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView gologout() {
		ModelAndView login = new ModelAndView("login");

		return login;
	}

	@RequestMapping(value = "/login2", method = RequestMethod.GET)
    public ModelAndView goLogin2() {
        ModelAndView login = new ModelAndView("login2");
        login.addObject("greeting", "Thank you for coming!");
        return login;
    }

	@RequestMapping(value = "/authenication", method = RequestMethod.GET)
    public ModelAndView goAuthenication() {
        ModelAndView authenication = new ModelAndView("authenication");
        authenication.addObject("greeting", "Thank you for coming!");
        return authenication;
    }
}
