package com.example.dx195.androidbootcamp.Services;

import android.util.Log;

import com.example.dx195.androidbootcamp.Model.Team;

import org.apache.http.HttpEntity;

import java.util.Hashtable;

/**
 * Created by younghoyoo on 2014-09-14.
 */
public class AllTeamsDataServiceParser {
    public static Hashtable<String,Team> parseAllTeamsData(HttpEntity httpEntity) {
        Hashtable allTeams = new Hashtable<String,Team>();
        try {
/*
            //Build the JSON String
            InputStream inputStream = httpEntity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line + "\n");
            }
            JSONObject jsonObject = new JSONObject(jsonString.toString());
            JSONArray jsonConferencesArray = jsonObject.getJSONArray("conferences");

            for(int i = 0; i < jsonConferencesArray.length(); i++) {
                JSONObject jsonSubdivisions = jsonConferencesArray.getJSONObject(i);

                int subds = jsonSubdivisions.length();
                for(int j = 0; j < jsonSubdivisions.length(); j++) {
                    JSONArray jsonSubdivisionArray = jsonSubdivisions.getJSONArray("subdivisions");

                    int subd2 = jsonSubdivisionArray.length();
                    for(int k = 0; k < jsonSubdivisionArray.length(); k++) {
                        JSONObject jsonSubdivision = jsonSubdivisionArray.getJSONObject(k);

                        JSONArray jsonTeamsArray = jsonSubdivision.getJSONArray("teams");
                        int teams = jsonTeamsArray.length();
                        for(int l = 0; l < jsonTeamsArray.length(); l++) {
                            JSONObject teamObject = jsonTeamsArray.getJSONObject(l);

                            String teamId = teamObject.getString("id");
                            String teamMarket = teamObject.getString("market");
                            String teamName = teamObject.getString("name");

                            allTeams.put(teamId, new Team(teamId, teamMarket, teamName));
                        }
                    }
                }
            }
        */} catch (Exception e) {
            Log.e("ERROR PARSING TOP TEAMS", e.getMessage());
        }
        return allTeams;
    }
}

