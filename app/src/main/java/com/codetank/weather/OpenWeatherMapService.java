package com.codetank.weather;

import com.codetank.weather.data.CurrentWeather;
import com.codetank.weather.data.FiveDayForecast;

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

    @GET("data/2.5/forecast?")
    Call<FiveDayForecast> fiveDayForecast(@Query("q") String city,
                                          @Query("units") String unit,
                                          @Query("apikey") String apiKey);
}
