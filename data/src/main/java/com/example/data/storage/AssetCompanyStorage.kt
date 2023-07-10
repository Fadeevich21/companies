package com.example.data.storage

import android.content.Context
import com.example.data.storage.model.CompaniesResponse
import com.example.data.storage.model.CompanyDto
import com.example.data.storage.utils.CompanyStorage
import com.google.gson.Gson
import javax.inject.Inject

class AssetCompanyStorage @Inject constructor(
    private val context: Context,
) : CompanyStorage {

    override suspend fun getAllCompanies(): List<CompanyDto> {
        val jsonString = context.assets.open("companies.json")
            .bufferedReader()
            .use {
                it.readText()
            }

        return Gson().fromJson(jsonString, CompaniesResponse::class.java).companies
    }
}