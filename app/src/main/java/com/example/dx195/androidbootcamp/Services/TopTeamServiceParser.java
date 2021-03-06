package com.example.dx195.androidbootcamp.Services;

import android.util.Log;

import com.example.dx195.androidbootcamp.Model.Team;

import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dx195 on 9/11/14.
 */
public class TopTeamServiceParser {

    public static ArrayList<Team> parseTopTeams(HttpEntity httpEntity) {
        ArrayList<Team> teams = new ArrayList<Team>();
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

            JSONArray jsonTeams = jsonObject.getJSONArray("rankings");
            for(int i = 0; i < jsonTeams.length(); i++) {
                JSONObject team = jsonTeams.getJSONObject(i);

                String teamId = team.getString("id");
                String teamMarket = team.getString("market");
                String teamName = team.getString("name");
                int teamRank = team.getInt("rank");

                teams.add(new Team(teamId, teamMarket, teamName, teamRank));
            }
        } catch (Exception e) {
            Log.e("ERROR PARSING TOP TEAMS", e.getMessage());
        }
        return teams;
    }
}
