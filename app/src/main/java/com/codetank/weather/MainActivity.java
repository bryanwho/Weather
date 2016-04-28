package com.codetank.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.codetank.weather.data.CurrentWeather;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    public static final String BASE_API = "http://api.openweathermap.org/";
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
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …

        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        OpenWeatherMapService openWeatherMapService = retrofit.create(OpenWeatherMapService.class);

        Call<CurrentWeather> currentWeatherCall = openWeatherMapService.currentWeatherByZip("11003,us", API_KEY);

        currentWeatherCall.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                Log.d("flow", "success: " + response.body().getName());
                Log.d("flow", "success: " + response.body().getBase());
                Log.d("flow", "success: " + response.body().getId());
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                Log.d("flow", "failure");
            }
        });
    }

}
