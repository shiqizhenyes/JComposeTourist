package me.zack.jct

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import me.zack.jct.ui.theme.JComposeTouristTheme
import okhttp3.internal.wait

class SliderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JComposeTouristTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SliderGreeting()
                }
            }
        }
    }
}




@Composable
fun SliderGreeting() {
    var progress by remember {
        mutableStateOf(0f)
    }
    Slider(value = progress, onValueChange = {
        progress = it
    },
        colors = SliderDefaults.colors(
            thumbColor = Color.White,
            activeTrackColor = Color(0xFF0079D3)
        ),)
}


@Preview("Light Mode")
@Preview("Night Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SliderGreetingPreView() {
    JComposeTouristTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            SliderGreeting()
        }
    }
}