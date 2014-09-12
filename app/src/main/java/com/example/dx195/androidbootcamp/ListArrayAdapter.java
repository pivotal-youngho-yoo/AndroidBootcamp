package com.example.dx195.androidbootcamp;

import com.example.dx195.androidbootcamp.Model.Team;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by dx195 on 9/11/14.
 */
public class ListArrayAdapter extends ArrayAdapter<Team> {
    private ArrayList<Team> teams;
    private Context context;

    public ListArrayAdapter(Context context, ArrayList<Team> teams) {
        super(context, R.layout.scheduled_game_item, teams);
        this.teams = teams;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Team team = teams.get(position);

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.scheduled_game_item, parent, false);
        TextView title = (TextView) convertView.findViewById(R.id.homeTeam);
        title.setText(team.getMarketName());

        return convertView;
    }
}
