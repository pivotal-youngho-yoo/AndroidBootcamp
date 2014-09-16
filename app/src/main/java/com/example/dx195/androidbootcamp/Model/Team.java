package com.example.dx195.androidbootcamp.Model;

/**
 * Created by dx195 on 9/11/14.
 */
public class Team {
    private String id;
    private String marketName;
    private String teamName;
    private int rank;

    public Team(String id, String marketName, String teamName, int rank) {
        this.id = id;
        this.marketName = marketName;
        this.teamName = teamName;
        this.rank = rank;
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

    public int getRank() { return rank; }
}
