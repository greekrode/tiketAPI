package com.example.roder.tiketapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.roder.tiketapi.R;
import com.example.roder.tiketapi.model.Airport;

import java.util.List;

/**
 * Created by roder on 2/9/2018.
 */

public class AirportsAdapter extends RecyclerView.Adapter<AirportsAdapter.AirportViewHolder> {

    private List<Airport> airports;
    private int rowLayout;
    private Context context;

    public static class AirportViewHolder extends RecyclerView.ViewHolder {
        LinearLayout airportsLayout;
        TextView airportName, airportCode, locationName, countryId, countryName;

        public AirportViewHolder(View v){
            super(v);
            airportsLayout = (LinearLayout) v.findViewById(R.id.airportsLayout);
            airportCode = (TextView) v.findViewById(R.id.airportCode);
            airportName = (TextView) v.findViewById(R.id.airportName);
            locationName = (TextView) v.findViewById(R.id.locationName);
            countryId = (TextView) v.findViewById(R.id.countryId);
            countryName = (TextView) v.findViewById(R.id.countryName);
        }
    }

    public AirportsAdapter(List<Airport> airports, int rowLayout, Context context) {
        this.airports = airports;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public AirportsAdapter.AirportViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new AirportViewHolder(view);
    }

    public void onBindViewHolder(AirportViewHolder holder, final int position) {
        holder.airportCode.setText(airports.get(position).getAirportCode());
        holder.airportName.setText(airports.get(position).getAirportName());
        holder.locationName.setText(airports.get(position).getLocationName());
        holder.countryName.setText(airports.get(position).getCountryName());
        holder.countryId.setText(airports.get(position).getCountryId());
    }

    @Override
    public int getItemCount() {
        return airports.size();
    }

}
