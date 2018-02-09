package com.example.roder.tiketapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by roder on 2/9/2018.
 */

public class AirportsResponse {
    public List<Airport> getAirport() {
        return airport;
    }

    public void setAirport(List<Airport> airport) {
        this.airport = airport;
    }

    @SerializedName("airport")
    private List<Airport> airport;
}
