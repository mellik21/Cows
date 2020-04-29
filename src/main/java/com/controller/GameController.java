package com.controller;

import com.entity.User;
import com.model.Game;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GameController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    /**
     * GET Загружает страницу игры
     * Создает новую игру - генерирует новое число
     * Обнуляет число попыток
     */
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public ModelAndView loadGame(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("game");
        Game game = new Game();
        User user = (User) httpSession.getAttribute("user");
        httpSession.setAttribute("game", game);
        modelAndView.addObject("username", user.getLogin());
        modelAndView.addObject("score", 0);
        httpSession.setAttribute("score", 0);
        return modelAndView;
    }
    /**
     * GET Вызывается при нажатии на кнопку "Новая игра" или угадывании
     * Создает новую игру и записывает результаты предыдущей
     * Обновляет рейтинг у пользователя
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView game(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) httpSession.getAttribute("user");
        //Нашла ошибку - если пользователь начал новую игру, считается что он угадал с первой попытки
        int score = (int) httpSession.getAttribute("score");
        userService.addScore(user,score);
        Game newGame = new Game();
        modelAndView.addObject("game", newGame);
        modelAndView.setViewName("redirect:/game");

        return modelAndView;
    }

    /**
     * POST Проверяет число введенное пользователем
     * Увеличивает число попыток при неугадывании
     * Перенаправляет на создание новой игры при угадывании
     */
    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public ModelAndView testValue(HttpSession httpSession, @RequestParam("select") int[] nums) {
        System.out.println(Arrays.toString(nums));
        ModelAndView modelAndView = new ModelAndView();
        Game game = (Game) httpSession.getAttribute("game");
        int score = (int) httpSession.getAttribute("score");
        if (game.check(nums)) {
            modelAndView.setViewName("redirect:/new");
        } else {
            score++;
            modelAndView.addObject("score", score);
            modelAndView.addObject("game",game);

            System.out.println(Arrays.toString(game.getResults().toArray()));

            modelAndView.setViewName("game");
        }
        User user = (User) httpSession.getAttribute("user");
        modelAndView.addObject("username", user.getLogin());
        httpSession.setAttribute("score", score);
        return modelAndView;
    }
}
