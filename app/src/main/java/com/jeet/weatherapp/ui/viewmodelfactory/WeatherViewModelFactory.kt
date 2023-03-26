package com.jeet.weatherapp.ui.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeet.weatherapp.data.repositories.WeatherRepository
import com.jeet.weatherapp.ui.viewmodel.WeatherViewModel

@Suppress("UNCHECKED_CAST")
class WeatherViewModelFactory(
    private val repository: WeatherRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(repository) as T
    }
}
