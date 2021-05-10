package com.example.doordashlite.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doordashlite.data.StoreFeedResponse
import com.example.doordashlite.repository.MainRepository
import com.example.doordashlite.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
        private val mainRepository: MainRepository
): ViewModel(){

    private val DFLT_LAT: Double = 37.422740
    private val DFLT_LONG: Double = -122.139956

    private val _res = MutableLiveData<Resource<StoreFeedResponse>>()

    val res : LiveData<Resource<StoreFeedResponse>>
        get() = _res

    init {
        getEmployees()
    }

    private fun getEmployees()  = viewModelScope.launch {
        _res.postValue(Resource.loading(null))
        mainRepository.getListOfStores(DFLT_LAT, DFLT_LONG).let {
            if (it.isSuccessful){
                _res.postValue(Resource.success(it.body()))
            }else{
                _res.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }

}