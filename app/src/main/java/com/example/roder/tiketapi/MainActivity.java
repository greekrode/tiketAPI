package com.example.roder.tiketapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.roder.tiketapi.adapter.AirportsAdapter;
import com.example.roder.tiketapi.model.Airport;
import com.example.roder.tiketapi.model.AirportsResponse;
import com.example.roder.tiketapi.rest.ApiClient;
import com.example.roder.tiketapi.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private final static String token = "dd67aad276f222a56f65549296660c04208be2a0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (token.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your TOKEN first from tiket.com", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.airports_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<AirportsResponse> call = apiService.getAirportDetails(token);
        call.enqueue(new Callback<AirportsResponse>() {
            @Override
            public void onResponse(Call<AirportsResponse>call, Response<AirportsResponse> response) {
                int statusCode = response.code();
                List<Airport> airports = response.body().getAirport();
                recyclerView.setAdapter( new AirportsAdapter(airports, R.layout.list_item_airport, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<AirportsResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}


