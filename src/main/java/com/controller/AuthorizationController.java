package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@RestController
public class AuthorizationController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Загрузка страницы - перенаправляет на страницу авторизации
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView load() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/authentication");
        return modelAndView;
    }

    /**
     * GET Загружает страницу авторизации
     */
    @RequestMapping(value = "/authentication", method = RequestMethod.GET)
    public ModelAndView loadStartPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authentication");
        return modelAndView;
    }
    /**
     * POST Проверяет наличие пользователя в бд и перенаправляет на главную страницу
     */
    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    public ModelAndView authenticate(HttpSession httpSession, @ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();

        int id = userService.find(user);

        if(id == -1){
            modelAndView.setView(loadStartPage().getView());
            System.out.println("Пользователь не найден");
        }else{
            user.setId(id);
            httpSession.setAttribute("user",user);
            modelAndView.setViewName("redirect:/rating");
        }
        return modelAndView;
    }
    /**
     * GET Загружает страницу регистрации
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    /**
     * POST добавляет нового пользователя
     * Устанавливает рейтинг и число игр - 0
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        user.setScore(0);
        user.setGame(0);
        user.setSum(0);
        userService.add(user);
        modelAndView.getModelMap().clear();
        modelAndView.setViewName("redirect:/authentication");

        return modelAndView;
    }

}
