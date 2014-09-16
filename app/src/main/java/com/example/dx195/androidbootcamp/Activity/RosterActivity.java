package com.example.dx195.androidbootcamp.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.dx195.androidbootcamp.Model.Player;
import com.example.dx195.androidbootcamp.R;
import com.example.dx195.androidbootcamp.RosterArrayAdapter;
import com.example.dx195.androidbootcamp.Services.RosterService;

import java.util.ArrayList;


public class RosterActivity extends Activity {

    ListView rosterList;
    ArrayList<Player> roster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_cell);

        rosterList = (ListView) findViewById(R.id.listView);
        RosterService requestRoster = new RosterService(this);
        requestRoster.makeRequest();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.team, menu);
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

    public void setRoster(ArrayList<Player> players) {
        roster = players;
        RosterArrayAdapter adapter = new RosterArrayAdapter(this, players);
        rosterList.setAdapter(adapter);
    }
}
