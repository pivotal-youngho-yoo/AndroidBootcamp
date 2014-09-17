package com.example.dx195.androidbootcamp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.dx195.androidbootcamp.ListArrayAdapter;
import com.example.dx195.androidbootcamp.Model.Team;
import com.example.dx195.androidbootcamp.R;
import com.example.dx195.androidbootcamp.Services.TopTeamService;

import java.util.ArrayList;


public class TopTeamActivity extends Activity {

    ListView topTeamList;
    ProgressBar progressBar;
    ArrayList<Team> topTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_list);

        //get list of the top 25 NCAA football teams
        topTeamList = (ListView) findViewById(R.id.listView);
        TopTeamService requestTopTeams = new TopTeamService(this);

        progressBar = (ProgressBar) findViewById(R.id.teamListProgressBar);
        progressBar.setVisibility(View.VISIBLE);

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
        return super.onOptionsItemSelected(item);
    }

    // Receive the response for the top 25 teams.
    public void setTeams(ArrayList<Team> teams) {
        progressBar.setVisibility(View.GONE);
        topTeams = teams;
        ListArrayAdapter adapter = new ListArrayAdapter(this, teams);
        topTeamList.setAdapter(adapter);

        // When a team is selected show the roster of the team

        topTeamList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TopTeamActivity.this, RosterActivity.class);
                intent.putExtra("teamId", topTeams.get(position).getId());
                startActivity(intent);
            }
        });

    }
}
