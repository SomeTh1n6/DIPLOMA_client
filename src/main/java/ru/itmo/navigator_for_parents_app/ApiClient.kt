package ru.itmo.navigator_for_parents_app

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import ru.itmo.navigator_for_parents_app.data.Item

data class EchoResponse(val echo: String)

interface FastAPIService {
    @POST("/echo/")
    fun echo(@Body text: Item): Call<EchoResponse>
}
