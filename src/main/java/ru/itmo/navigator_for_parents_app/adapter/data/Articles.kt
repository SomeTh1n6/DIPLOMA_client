package ru.itmo.navigator_for_parents_app.adapter.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Articles(
    val title: String,
    val description: String,
    val content: String
) : Parcelable
