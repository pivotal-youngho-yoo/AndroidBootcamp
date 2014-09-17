package com.example.dx195.androidbootcamp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dx195.androidbootcamp.Model.Player;

import java.util.ArrayList;

/**
 * Created by younghoyoo on 2014-09-15.
 */
public class RosterArrayAdapter extends ArrayAdapter<Player> {
    private ArrayList<Player> players;
    private Context context;

    public RosterArrayAdapter(Context context, ArrayList<Player> players) {
        super(context, R.layout.player_cell , players);
        this.players = players;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player player = players.get(position);

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.player_cell, parent, false);
        TextView playerName = (TextView) convertView.findViewById(R.id.playerName);
        playerName.setText(player.getName());

        TextView playerNumber = (TextView) convertView.findViewById(R.id.playerNumber);
        playerNumber.setText(String.valueOf(player.getJerseyNumber()));

        TextView playerPosition = (TextView) convertView.findViewById(R.id.playerPosition);
        playerPosition.setText(player.getPosition());

        return convertView;
    }
}
