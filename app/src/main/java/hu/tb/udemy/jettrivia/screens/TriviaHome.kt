package hu.tb.udemy.jettrivia.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import hu.tb.udemy.jettrivia.compoments.Questions

@Composable
fun TriviaHome(viewModel: QuestionViewModel = hiltViewModel()) {
    Questions(viewModel = viewModel)
}

