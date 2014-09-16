package com.example.dx195.androidbootcamp.Model;

/**
 * Created by younghoyoo on 2014-09-15.
 */
public class Player {
    private String name;
    private String position;
    private int jerseyNumber;

    public Player(String name, String position, int jerseyNumber) {
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
    }

    public String getName() { return name; }

    public String getPosition() { return position;}

    public int getJerseyNumber() {return jerseyNumber;}
}
