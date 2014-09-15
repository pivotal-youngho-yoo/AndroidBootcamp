package com.example.dx195.androidbootcamp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.dx195.androidbootcamp.Model.Game;
import com.example.dx195.androidbootcamp.Model.Team;
import com.example.dx195.androidbootcamp.Services.AllTeamsDataService;
import com.example.dx195.androidbootcamp.Services.TopTeamService;

import java.util.ArrayList;
import java.util.Hashtable;


public class FootballScheduleActivity extends Activity {

    ListView topTeamList;
    ArrayList<Team> topTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_schedule);

        //get list of the top 25 NCAA football teams
        topTeamList = (ListView) findViewById(R.id.listView);
        TopTeamService requestTopTeams = new TopTeamService(this);
        requestTopTeams.makeRequest();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.football_schedule, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Get the response for the top 25 teams.
    public void setTeams(ArrayList<Team> teams) {
        topTeams = teams;
        ListArrayAdapter adapter = new ListArrayAdapter(this, teams);
        topTeamList.setAdapter(adapter);

        //GameScheduleService requestGameSchedule = new GameScheduleService(this);
        //requestGameSchedule.makeRequest();
    }

    public void setGames(ArrayList<Game> games) {
        filterGames(games);

        //Request Data on all the teams
        AllTeamsDataService requestAllTeamsData = new AllTeamsDataService(this);
        requestAllTeamsData.makeRequest();
    }

    public void setAllTeamsData(Hashtable<String,Team> allTeams) {

    }

    // Filter the scheduled games by the top 25 teams
    private void filterGames(ArrayList<Game> games) {

    }
}
