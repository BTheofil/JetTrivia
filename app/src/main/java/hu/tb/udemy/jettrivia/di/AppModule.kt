package hu.tb.udemy.jettrivia.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.tb.udemy.jettrivia.network.QuestionApi
import hu.tb.udemy.jettrivia.repository.QuestionRepository
import hu.tb.udemy.jettrivia.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideQuestionApi(): QuestionApi =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)

    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionApi) =
        QuestionRepository(api)
}