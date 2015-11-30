package com.src.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.src.entity.User;
import com.src.service.MyServiceHelper;

@Controller
public class GeneralController {

    @Autowired
    MyServiceHelper myServiceHelper;

    @RequestMapping(value = {"/", "/home"})
    public ModelAndView goHome(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView home = new ModelAndView("home");
        try {
            myServiceHelper.service(req, res);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return home;
    }

    @RequestMapping(value = "/profile")
    public ModelAndView goProfile(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView profile = new ModelAndView("profile");

        try {

            User user = myServiceHelper.getUserProfile( );
            profile.addObject("user", user);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return profile;
    }

//    @RequestMapping(value = "/users")
//    public ModelAndView goListUser() {
//        ModelAndView listUser = new ModelAndView("listUser");
//        try {
//            List<User> users = myServiceHelper.getListUser();
//
//            for (User user: users ) {
//                System.out.println(user.toString());
//            }
//
//            listUser.addObject("users", users);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return listUser;
//    }

    @RequestMapping(value = "/signin")
    public ModelAndView goSignin() {
        ModelAndView sign = new ModelAndView("signin");
        return sign;
    }

    @RequestMapping(value = "/authorization")
    public ModelAndView goAuthorizaion() {
        ModelAndView authorizaion = new ModelAndView("authorization");
        return authorizaion;
    }
}
