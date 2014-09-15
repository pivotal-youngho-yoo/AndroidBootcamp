package com.example.dx195.androidbootcamp.Services;

import android.util.Log;

import com.example.dx195.androidbootcamp.Model.Game;
import com.example.dx195.androidbootcamp.Model.Team;

import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by younghoyoo on 2014-09-14.
 */
public class GameScheduleServiceParser {
    public static ArrayList<Game> parseGames(HttpEntity httpEntity) {
        ArrayList<Game> games= new ArrayList<Game>();
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

            JSONArray jsonTeams = jsonObject.getJSONArray("games");
            for(int i = 0; i < jsonTeams.length(); i++) {
                JSONObject game = jsonTeams.getJSONObject(i);

                String homeTeamId = game.getString("home");
                String awayTeamId = game.getString("away");
                String gameTimeString = game.getString("scheduled");

                Date gameTime;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss+hh:mm");
                gameTime = dateFormat.parse(gameTimeString);

                Team homeTeam = new Team(homeTeamId, null, null);
                Team awayTeam = new Team(awayTeamId, null, null);

                games.add(new Game(homeTeam, awayTeam, gameTime));
            }
        } catch (Exception e) {
            Log.e("ERROR PARSING TOP TEAMS", e.getMessage());
        }
        return games;
    }
}
