package com.example.appthemoviedb.presenter.moviedetails

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class DetailMoviesViewArg(
    val movieId: Int
) : Parcelable
