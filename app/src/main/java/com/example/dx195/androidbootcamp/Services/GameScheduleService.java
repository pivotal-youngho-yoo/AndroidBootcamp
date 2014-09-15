package com.example.dx195.androidbootcamp.Services;

import android.os.AsyncTask;
import android.util.Log;

import com.example.dx195.androidbootcamp.FootballScheduleActivity;
import com.example.dx195.androidbootcamp.Model.Game;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;

/**
 * Created by younghoyoo on 2014-09-14.
 */
public class GameScheduleService {
    static final String GAME_SCHEDULE_URL = "http://api.sportsdatallc.org/ncaafb-t1/2014/REG/2/schedule.json?api_key=jmtzp6kchp9n9vka5s7e6hje";
    FootballScheduleActivity display;

    public GameScheduleService(FootballScheduleActivity display) {
        this.display = display;
    }

    public void makeRequest() {
        new AsyncCall().execute(GAME_SCHEDULE_URL);
    }

    private class AsyncCall extends AsyncTask<String, Integer, ArrayList<Game>> {

        @Override
        protected ArrayList<Game> doInBackground(String... arg0) {
            ArrayList<Game> games = new ArrayList<Game>();
            String url = arg0[0];

            try {
                //Get Http entity
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet(url);
                HttpResponse response = client.execute(request);
                HttpEntity httpEntity = response.getEntity();

                // Parse the JSON Object
                if (httpEntity != null) {
                    games = GameScheduleServiceParser.parseGames(httpEntity);
                }

            } catch(Exception e) {
                Log.e("ERROR", e.getMessage());
            }

            return games;
        }

        protected void onPostExecute(ArrayList<Game> games) {
            super.onPostExecute(games);
            display.setGames(games);
        }
    }
}
