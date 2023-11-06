package hu.tb.udemy.jettrivia.network

import hu.tb.udemy.jettrivia.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {

    @GET("world.json")
    suspend fun getAllQuestion(): Question
}