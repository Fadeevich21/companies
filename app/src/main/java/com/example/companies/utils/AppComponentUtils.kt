package com.example.companies.utils

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.companies.App
import com.example.companies.di.AppComponent

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }

val Fragment.appComponent: AppComponent
    get() = requireContext().appComponent