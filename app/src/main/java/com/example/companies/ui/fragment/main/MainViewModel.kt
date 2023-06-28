package com.example.companies.ui.fragment.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.companies.ui.utils.Event
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {

    private var actionNavigateLiveMutable = MutableLiveData<Event<NavDirections>>()
    val actionNavigateLive: LiveData<Event<NavDirections>> = actionNavigateLiveMutable

    fun onClickAllCompaniesListener() {
        TODO("Not implemented")
    }

    fun onClickReviewsListener() {
        TODO("Not implemented")
    }

    fun onClickAnalysisReportsListener() {
        TODO("Not implemented")
    }

    fun onClickFavoriteCompaniesListener() {
        TODO("Not implemented")
    }
}