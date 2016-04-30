package com.codetank.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.codetank.weather.data.CurrentWeather;
import com.codetank.weather.data.FiveDayForecast;

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
    public static final String UNIT_FAHRENHEIT = "imperial";
    public static final String UNIT_CELSIUS = "metric";

    private TextView temp;
    private TextView locale;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp = (TextView) findViewById(R.id.temp);
        locale = (TextView) findViewById(R.id.locale);
        layout = (RelativeLayout) findViewById(R.id.background);
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

//        Call<CurrentWeather> currentWeatherCall = openWeatherMapService.currentWeatherByZip("11432,us","imperial", API_KEY);
//
//        currentWeatherCall.enqueue(new Callback<CurrentWeather>() {
//            @Override
//            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
//                Log.d("flow", "success: " + response.body().getName());
//                Log.d("flow", "success: " + response.body().getBase());
//                Log.d("flow", "success: " + response.body().getId());
//
//                populateCurrentWeather(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<CurrentWeather> call, Throwable t) {
//                Log.d("flow", "failure");
//            }
//        });

        Call<FiveDayForecast> fiveDayForecastCall = openWeatherMapService.fiveDayForecast("newyork","imperial",API_KEY);

        fiveDayForecastCall.enqueue(new Callback<FiveDayForecast>() {
            @Override
            public void onResponse(Call<FiveDayForecast> call, Response<FiveDayForecast> response) {
                Log.d("flow", "success: " + response.body().getCity().getName());
            }

            @Override
            public void onFailure(Call<FiveDayForecast> call, Throwable t) {
                Log.d("flow", "failure: " + t.getMessage());
            }
        });
    }

    private void populateCurrentWeather(CurrentWeather currentWeather) {
        temp.setText(Integer.toString((int)currentWeather.getMain().getTemp()) + "\u2109");
        locale.setText(currentWeather.getName());

        //changing background image based on temperature data
        if(currentWeather.getMain().getTemp() < 70){
            layout.setBackgroundResource(R.drawable.sky);
        }
    }

}
