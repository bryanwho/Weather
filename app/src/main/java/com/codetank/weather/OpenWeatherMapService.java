package com.codetank.weather;

import com.codetank.weather.data.CurrentWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by bryanokeke on 4/28/16.
 */
public interface OpenWeatherMapService {

    @GET("data/2.5/weather?")
    Call<CurrentWeather> currentWeatherByZip(@Query("zip") String zipCode,
                                             @Query("units") String unit,
                                             @Query("apikey") String apiKey);

//    @GET("weather?&zip=10001&apikey=2cf0967f5d444acf71bf234374c3885c")
//    Call<CurrentWeather> currentWeatherByZip1();
}
