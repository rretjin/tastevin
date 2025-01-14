package com.example.tastevin.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastevin.domain.Wine
import com.example.tastevin.network.WineApi
import com.example.tastevin.network.asDomainModel
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel() : ViewModel() {
    val topWines = MutableLiveData<List<Wine>>()

    init {
        getTopWineList()
    }

    private fun getTopWineList() {
        viewModelScope.launch {
            Timber.tag("JSON").d("Network started")
            try {
                val networkWines = WineApi.retrofitService.getTopWines()
                val wines = networkWines.map { it.asDomainModel() }
                topWines.postValue(wines)
                Timber.tag("JSON").d(networkWines.toString())
            } catch (e: Exception) {
                Timber.tag("JSON").e(e.toString())
            }
        }
    }
}