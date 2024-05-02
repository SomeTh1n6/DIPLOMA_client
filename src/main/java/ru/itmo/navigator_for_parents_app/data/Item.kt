package ru.itmo.navigator_for_parents_app.data
import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("text")
    val text: String
)