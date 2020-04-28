package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "game")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "score")
    private int score;
    @Column(name = "sum")
    private int sum;
    @Column(name = "game")
    private int game;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public int getScore() {
        return score;
    }
    public void setSum(int sum){
        this.sum=sum;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void updateScore(int newScore){
        sum+=newScore;
        game++;
        score = sum/game;
    }
}