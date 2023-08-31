package me.zack.jct

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.zack.jct.ui.theme.JComposeTouristTheme

class SurfaceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JComposeTouristTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SurfaceGreeting("Android")
                }
            }
        }
    }
}

@Composable
fun SurfaceGreeting(name: String, modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 10.dp,
        modifier = Modifier
            .width(300.dp)
            .height(100.dp)
    ) {
        Row(modifier = Modifier.clickable {

        }){
            Image(painter = painterResource(id = R.drawable.fo_do_full), contentDescription = "Fo do full",
                modifier = Modifier.size(100.dp), contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.padding(horizontal = 12.dp))
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                Text(text = "Liratie", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                Text(text = "礼谙")
            }
        }
    }
}

@Preview("Light Mode")
@Preview("Night Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SurfaceGreetingPreview() {
    JComposeTouristTheme {
        SurfaceGreeting("Android")
    }
}