package ru.itmo.navigator_for_parents_app.adapter.data_notes

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Notes(
    val date: String,
    val time: String,
    val specialist: String,
    val adress: String
) : Parcelable