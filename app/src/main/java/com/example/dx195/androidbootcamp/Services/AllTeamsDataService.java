package com.example.dx195.androidbootcamp.Services;

import android.os.AsyncTask;
import android.util.Log;

import com.example.dx195.androidbootcamp.FootballScheduleActivity;
import com.example.dx195.androidbootcamp.Model.Team;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.Hashtable;

/**
 * Created by younghoyoo on 2014-09-14.
 */
public class AllTeamsDataService {
    static final String ALL_TEAMS_DATA_URL = "http://api.sportsdatallc.org/ncaafb-t1/teams/FBS/hierarchy.json?api_key=jmtzp6kchp9n9vka5s7e6hje";
    FootballScheduleActivity display;

    public AllTeamsDataService(FootballScheduleActivity display) {
        this.display = display;
    }

    public void makeRequest() {
        new AsyncCall().execute(ALL_TEAMS_DATA_URL);
    }

    private class AsyncCall extends AsyncTask<String, Integer, Hashtable<String,Team>> {

        @Override
        protected Hashtable<String, Team> doInBackground(String... arg0) {
            Hashtable<String, Team> teams = new Hashtable<String, Team>();
            String url = arg0[0];

            try {
                //Get Http entity
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet(url);
                HttpResponse response = client.execute(request);
                HttpEntity httpEntity = response.getEntity();

                // Parse the JSON Object
                if (httpEntity != null) {
                    teams = AllTeamsDataServiceParser.parseAllTeamsData(httpEntity);
                }

            } catch(Exception e) {
                Log.e("ERROR", e.getMessage());
            }

            return teams;
        }

        protected void onPostExecute(Hashtable<String,Team> teams) {
            super.onPostExecute(teams);
            display.setAllTeamsData(teams);
        }
    }
}
