package com.anywhereapps.yelp.test.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anywhereapps.yelp.test.data.repository.MainRepository
import com.anywhereapps.yelp.test.ui.main.viewmodel.MainViewModel

class ViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                MainRepository()
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}

