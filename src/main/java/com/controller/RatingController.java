package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class RatingController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * GET Загружает страницу с рейтингом
     * Получает список всех пользователей и сортирует их в порядке возрастания среднего числа попыток
     */
    @RequestMapping(value = "/rating", method = RequestMethod.GET)
    public ModelAndView loadRating(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rating");
        User user = (User) httpSession.getAttribute("user");
        List<User> userList = userService.getAll();
        Collections.sort(userList);
        modelAndView.addObject("users",userList);
        modelAndView.addObject("username", user.getLogin());
        return modelAndView;
    }

}

