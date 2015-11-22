package com.src.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.src.entity.Account;
import com.src.model.AccountDAOImp;

@Controller
@RequestMapping("/user")
public class UserController {

 @Autowired
 AccountDAOImp accountDAOImp;

 @RequestMapping(value = "/information", method = RequestMethod.GET)
 @ResponseBody
 public Account profile() throws Exception {

     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     String username = auth.getName();
     System.out.println(username);
     Account account = accountDAOImp.findUserByUserName(username);
     return account;
 }
}