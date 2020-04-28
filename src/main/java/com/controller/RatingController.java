package com.controller;

import com.entity.User;
import com.model.Game;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class RatingController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/rating", method = RequestMethod.GET)
    public ModelAndView loadRating(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rating");
        User user = (User) httpSession.getAttribute("user");


        modelAndView.addObject("username", user.getLogin());
        return modelAndView;
    }

}

