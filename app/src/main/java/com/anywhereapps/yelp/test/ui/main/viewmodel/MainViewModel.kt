package com.anywhereapps.yelp.test.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anywhereapps.sdk.listener.ResponseListener
import com.anywhereapps.sdk.model.Establishment
import com.anywhereapps.yelp.test.data.repository.MainRepository
import com.anywhereapps.yelp.test.utils.Resource


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val liveData = MutableLiveData<Resource<Establishment?>>()

    fun getEstablishments(term : String, latitude : Double, longitude : Double, radius : String) : LiveData<Resource<Establishment?>> {
        liveData.value = Resource.loading(data = null)
        try {
            mainRepository.getEstablishment(term, latitude, longitude, radius, object : ResponseListener<Establishment?>{
                override fun onSuccess(response: Establishment?) {
                    liveData.value = Resource.success(data = response)
                }

                override fun onError(t: Throwable) {
                    liveData.value = Resource.error(data = null, message = t.message ?: "Error Occurred!")
                }
            })
        }
        catch (exception: Exception) {
            liveData.value = Resource.error(data = null, message = exception.message ?: "Error Occurred!")
        }

       return liveData
    }

}
