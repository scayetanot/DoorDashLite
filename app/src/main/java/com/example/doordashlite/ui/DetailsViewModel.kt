package com.example.doordashlite.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doordashlite.data.RestaurantResponse
import com.example.doordashlite.data.StoreFeedResponse
import com.example.doordashlite.repository.MainRepository
import com.example.doordashlite.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
        private val mainRepository: MainRepository
): ViewModel(){

    private val _res = MutableLiveData<Resource<RestaurantResponse>>()

    val res : LiveData<Resource<RestaurantResponse>>
        get() = _res

    fun getRestaurantDetails(businessId: Int) = viewModelScope.launch {
        _res.postValue(Resource.loading(null))
        mainRepository.getRestaurantDetails(businessId).let {
            if(it.isSuccessful) {
                _res.postValue(Resource.success(it.body()))
            } else {
                _res.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }

}