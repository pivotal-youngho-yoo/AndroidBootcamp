package com.example.dx195.androidbootcamp.Services;

import android.util.Log;

import com.example.dx195.androidbootcamp.Model.Player;

import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by younghoyoo on 2014-09-15.
 */
public class RosterServiceParser {
    public static ArrayList<Player> parseRoster(HttpEntity httpEntity) {
        ArrayList<Player> players = new ArrayList<Player>();
        try {
            //Build the JSON String
            InputStream inputStream = httpEntity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line + "\n");
            }
            JSONObject jsonObject = new JSONObject(jsonString.toString());

            JSONArray jsonRoster = jsonObject.getJSONArray("players");
            for(int i = 0; i < jsonRoster.length(); i++) {
                JSONObject player = jsonRoster.getJSONObject(i);

                String name = player.getString("name");
                String position = player.getString("position");
                int jerseyNumber = player.getInt("jersey");

                players.add(new Player(name, position, jerseyNumber));
            }
        } catch (Exception e) {
            Log.e("ERROR PARSING TOP TEAMS", e.getMessage());
        }
        return players;
    }
}
