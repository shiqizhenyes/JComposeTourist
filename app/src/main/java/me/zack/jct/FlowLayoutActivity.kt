package me.zack.jct

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.zack.jct.ui.theme.JComposeTouristTheme

class FlowLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JComposeTouristTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FlowLayoutGreeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Filters() {
    val filters = listOf("Washer/Dryer", "Ramp access", "Garden", "Cats OK", "Dogs OK", "Smoke-free")
    FlowRow {
        filters.forEach {title ->
            val selected by remember {
                mutableStateOf(false)
            }
            val leadingIcon: @Composable () -> Unit = { Icon(Icons.Default.Check, contentDescription = "Check")}
            FilterChip(selected = selected, onClick = { /*TODO*/ }, label = {
                Text(text = title, color = MaterialTheme.colorScheme.primaryContainer)
            }, leadingIcon = if (selected) leadingIcon else null)
        }
    }
}

@Composable
fun FlowLayoutGreeting(name: String, modifier: Modifier = Modifier) {
    Filters()
}

@Preview(name = "Light Mode")
@Preview(name = "Night Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FlowLayoutGreetingPreview() {
    JComposeTouristTheme {
        FlowLayoutGreeting("Android")
    }
}