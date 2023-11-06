package hu.tb.udemy.jettrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import hu.tb.udemy.jettrivia.screens.TriviaHome
import hu.tb.udemy.jettrivia.ui.theme.JetTriviaTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTriviaTheme {
                TriviaHome()
            }
        }
    }
}