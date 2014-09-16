package com.example.dx195.androidbootcamp.Services;

import android.os.AsyncTask;
import android.util.Log;

import com.example.dx195.androidbootcamp.Activity.TopTeamActivity;
import com.example.dx195.androidbootcamp.Model.Team;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;

/**
 * Created by dx195 on 9/11/14.
 */
public class TopTeamService {
    static final String TOP_TEAM_URL = "http://api.sportsdatallc.org/ncaafb-t1/polls/AP25/2014/2/rankings.json?api_key=ztkk39s99j7j4facu8b5cnk3";
    TopTeamActivity display;

    public TopTeamService(TopTeamActivity display) {
        this.display = display;
    }

    public void makeRequest() {
        new AsyncCall().execute(TOP_TEAM_URL);
    }

    private class AsyncCall extends AsyncTask<String, Integer, ArrayList<Team>> {

        @Override
        protected ArrayList<Team> doInBackground(String... arg0) {
            ArrayList<Team> teams = new ArrayList<Team>();
            String url = arg0[0];

            try {
                //Get Http entity
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet(url);
                HttpResponse response = client.execute(request);
                HttpEntity httpEntity = response.getEntity();

                // Parse the JSON Object
                if (httpEntity != null) {
                    teams = TopTeamServiceParser.parseTopTeams(httpEntity);
                }

            } catch(Exception e) {
                Log.e("ERROR", e.getMessage());
            }

            return teams;
        }

        protected void onPostExecute(ArrayList<Team> teams) {
            super.onPostExecute(teams);
            display.setTeams(teams);
        }
    }

}
