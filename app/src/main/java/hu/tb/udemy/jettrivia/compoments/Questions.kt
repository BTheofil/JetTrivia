package hu.tb.udemy.jettrivia.compoments

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.tb.udemy.jettrivia.screens.QuestionViewModel
import hu.tb.udemy.jettrivia.util.AppColors

@Composable
fun Questions(viewModel: QuestionViewModel) {

    val questions = viewModel.data.value.data?.toMutableList()

    if (viewModel.data.value.loading == true) {
        CircularProgressIndicator()
        Log.d("MYTAG", "Question: ...Loading...")
    } else {
        Log.d("MYTAG", "Question: " + questions?.size)
    }

}

@Composable
fun QuestionDisplay() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        color = AppColors.mDarkPurple
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            QuestionTracker(10, 100)
        }
    }
}

@Preview
@Composable
fun QuestionDisplayPreview() {
    QuestionDisplay()
}

@Composable
fun QuestionTracker(counter: Int, outOf: Int) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = ParagraphStyle(textIndent = TextIndent.None)
            ) {
                withStyle(
                    style = SpanStyle(
                        color = AppColors.mLightGray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 27.sp
                    )
                ) {
                    append("Question: $counter/")
                    withStyle(
                        style = SpanStyle(
                            color = AppColors.mLightGray,
                            fontWeight = FontWeight.Light,
                            fontSize = 14.sp
                        )
                    ) {
                        append("$outOf")
                    }
                }
            }
        },
        modifier = Modifier.padding(20.dp)
    )
}

@Preview
@Composable
fun QuestionTrackerPreview(counter: Int = 10, outOf: Int = 100) {
    QuestionTracker(counter, outOf)
}

