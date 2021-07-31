package com.example.dewiretrovit.service;

import com.example.dewiretrovit.model.WeatherModel;
import com.example.dewiretrovit.modelforecast.ForecastWeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterfacesRest {
    @GET("weather")
    Call<WeatherModel> getWeather(@Query("q") String q, @Query("appid") String appid);

    @GET("weather")
    Call<WeatherModel> getWeatherBasedLocation(@Query("lat") Double lat, @Query("lon") Double lon, @Query("appid") String appid);

    @GET("forecast")
    Call<ForecastWeatherModel> getForecastBasedLocation(@Query("lat") Double lat, @Query("lon") Double lon, @Query("appid") String appid);
}
