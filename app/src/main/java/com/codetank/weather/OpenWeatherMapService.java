package com.codetank.weather;

import com.codetank.weather.data.CurrentWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by bryanokeke on 4/28/16.
 */
public interface OpenWeatherMapService {

    @GET("weather?")
    Call<CurrentWeather> currentWeatherByZip(@Query("apiKey") String apiKey,
                                             @Query("zipCode") String zipCode,
                                             @Query("countryCode") String countryCode);

    @GET("weather?&zip=10001&apikey=2cf0967f5d444acf71bf234374c3885c")
    Call<CurrentWeather> currentWeatherByZip1();
}
