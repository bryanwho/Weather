package com.codetank.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.codetank.weather.data.CurrentWeather;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    public static final String BASE_API = "http://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "2cf0967f5d444acf71bf234374c3885c";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onResume() {
        super.onResume();
        retrofit();
    }

    public void retrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenWeatherMapService openWeatherMapService = retrofit.create(OpenWeatherMapService.class);


        Call<CurrentWeather> currentWeatherCall = openWeatherMapService.currentWeatherByZip1();

        currentWeatherCall.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                Log.d("flow", "success: " + response.body().getName());
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                Log.d("flow", "failure");
            }
        });
    }




}
