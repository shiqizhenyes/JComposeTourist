package me.zack.jct

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.zack.jct.ui.theme.JComposeTouristTheme

class BoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JComposeTouristTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Box {
        Box(modifier = Modifier
            .size(150.dp)
            .background(color = Color.Green))
        Box(modifier = Modifier
            .size(80.dp)
            .background(color = Color.Red))
        Text(text = "世界")
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Night Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview2() {
    JComposeTouristTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting2("Android")
        }
    }
}