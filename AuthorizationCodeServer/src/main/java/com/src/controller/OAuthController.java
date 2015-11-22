package com.src.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("authorizationRequest")
public class OAuthController {

	@RequestMapping(value = "/oauth/custom_confirm_access")
	public ModelAndView authorization(HttpServletRequest req) {
		ModelAndView authorize = new ModelAndView("authorize");
		String path = req.getContextPath();

		authorize.addObject("path", path);
		return authorize;
	}
}
