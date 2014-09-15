package com.example.dx195.androidbootcamp.Model;

import java.util.Date;

/**
 * Created by younghoyoo on 2014-09-14.
 */
public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private Date date;

    public Game(Team homeTeam, Team awayTeam, Date date) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Date getDate() {
        return date;
    }
}
