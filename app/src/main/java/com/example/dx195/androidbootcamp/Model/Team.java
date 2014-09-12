package com.example.dx195.androidbootcamp.Model;

/**
 * Created by dx195 on 9/11/14.
 */
public class Team {
    private String id;
    private String marketName;
    private String teamName;

    public Team(String id, String marketName, String teamName) {
        this.id = id;
        this.marketName = marketName;
        this.teamName = teamName;
    }

    public String getId() {
        return id;
    }

    public String getMarketName() {
        return marketName;
    }

    public String getTeamName() {
        return teamName;
    }
}
