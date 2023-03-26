package com.jeet.weatherapp.data.repositories

import com.jeet.weatherapp.data.local.WeatherDatabase
import com.jeet.weatherapp.data.model.WeatherDataResponse
import com.jeet.weatherapp.data.model.WeatherDetail
import com.jeet.weatherapp.data.network.ApiInterface
import com.jeet.weatherapp.data.network.SafeApiRequest

class WeatherRepository(
    private val api: ApiInterface,
    private val db: WeatherDatabase
) : SafeApiRequest() {

    suspend fun findCityWeather(cityName: String): WeatherDataResponse = apiRequest {
        api.findCityWeatherData(cityName)
    }

    suspend fun addWeather(weatherDetail: WeatherDetail) {
        db.getWeatherDao().addWeather(weatherDetail)
    }

    suspend fun fetchWeatherDetail(cityName: String): WeatherDetail? =
        db.getWeatherDao().fetchWeatherByCity(cityName)

    suspend fun fetchAllWeatherDetails(): List<WeatherDetail> =
        db.getWeatherDao().fetchAllWeatherDetails()
}
