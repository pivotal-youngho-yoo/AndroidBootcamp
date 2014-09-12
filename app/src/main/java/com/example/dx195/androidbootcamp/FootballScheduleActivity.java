package com.example.dx195.androidbootcamp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import com.example.dx195.androidbootcamp.Model.Team;
import com.example.dx195.androidbootcamp.Services.TopTeamService;

import java.util.ArrayList;
import java.util.List;


public class FootballScheduleActivity extends Activity {

    ListView topTeamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_schedule);

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

    // Update the display after with the response
    public void setTeams(ArrayList<Team>teams) {
        ListArrayAdapter adapter = new ListArrayAdapter(this, teams);
        topTeamList.setAdapter(adapter);

    }
}
