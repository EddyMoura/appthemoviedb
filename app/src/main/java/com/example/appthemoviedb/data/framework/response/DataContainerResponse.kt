package com.example.appthemoviedb.data.framework.response

import com.google.gson.annotations.SerializedName

data class DataContainerResponse<T>(
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<T>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
