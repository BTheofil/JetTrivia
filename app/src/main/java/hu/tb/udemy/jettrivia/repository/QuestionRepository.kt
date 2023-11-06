package hu.tb.udemy.jettrivia.repository

import android.util.Log
import hu.tb.udemy.jettrivia.data.DataOrException
import hu.tb.udemy.jettrivia.model.QuestionItem
import hu.tb.udemy.jettrivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionApi
) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestion()
            if (dataOrException.data.toString().isNotEmpty()) {
                dataOrException.loading = false
            }
        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("MYTAG", "getAllQuestions: " + dataOrException.e!!.localizedMessage)
        }
        return dataOrException
    }
}