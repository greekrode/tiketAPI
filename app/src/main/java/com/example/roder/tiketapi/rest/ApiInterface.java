package com.example.roder.tiketapi.rest;

import com.example.roder.tiketapi.model.AirportsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by roder on 2/9/2018.
 */

public interface ApiInterface {

    @GET("flight_api/all_airport")
    Call<AirportsResponse> getAirportDetails(@Query("token") String token);

}
