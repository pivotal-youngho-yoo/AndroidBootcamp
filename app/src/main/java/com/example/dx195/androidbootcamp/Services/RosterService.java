package com.example.dx195.androidbootcamp.Services;

import android.os.AsyncTask;
import android.util.Log;

import com.example.dx195.androidbootcamp.Activity.RosterActivity;
import com.example.dx195.androidbootcamp.Model.Player;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;

/**
 * Created by younghoyoo on 2014-09-15.
 */
public class RosterService {
    static final String ROSTER_URL = "http://api.sportsdatallc.org/ncaafb-t1/teams/OSU/2014/REG/statistics.json?api_key=jmtzp6kchp9n9vka5s7e6hje";
    RosterActivity display;

    public RosterService(RosterActivity display) {
        this.display = display;
    }

    public void makeRequest() {
        new AsyncCall().execute(ROSTER_URL);
    }

    private class AsyncCall extends AsyncTask<String, Integer, ArrayList<Player>> {

        @Override
        protected ArrayList<Player> doInBackground(String... arg0) {
            ArrayList<Player> players = new ArrayList<Player>();
            String url = arg0[0];

            try {
                //Get Http entity
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet(url);
                HttpResponse response = client.execute(request);
                HttpEntity httpEntity = response.getEntity();

                // Parse the JSON Object
                if (httpEntity != null) {
                    players = RosterServiceParser.parseRoster(httpEntity);
                }

            } catch(Exception e) {
                Log.e("ERROR", e.getMessage());
            }

            return players;
        }

        protected void onPostExecute(ArrayList<Player> players) {
            super.onPostExecute(players);
            display.setRoster(players);
        }
    }

}
