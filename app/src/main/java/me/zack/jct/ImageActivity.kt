package me.zack.jct

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import me.zack.jct.ui.theme.JComposeTouristTheme

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JComposeTouristTheme {
                Surface {
                    ImageGreeting()
                }
            }
        }
    }

}


@Composable
fun ImageGreeting() {
    Column() {
        Image(
            painter = painterResource(id = R.drawable.wallpaper),
            contentDescription = "anime-girl-airplane"
        )
        Image(
            painter = painterResource(id = R.drawable.wallpaper),
            contentDescription = "anime-girl-airplane",
            modifier = Modifier.size(350.0.dp)
        )
//        Surface(
//            shape = CircleShape
//        ) {
//            Image(painter = painterResource(id = R.drawable.wallpaper), contentDescription = "anime-girl-airplane",
//                modifier = Modifier.size(350.0.dp))
//        }
//        Surface(
//            shape = CircleShape,
//            border = BorderStroke(5.dp, Color.Gray)
//        ) {
//            Image(painter = painterResource(id = R.drawable.wallpaper), contentDescription = "anime-girl-airplane",
//                modifier = Modifier.size(240.0.dp), contentScale = ContentScale.Crop)
//        }
        Row {
            Image(
                painter = rememberImagePainter(data = "https://picsum.photos/300/300"),
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(5.0.dp))
            Image(
                painter = rememberAsyncImagePainter(model = "https://picsum.photos/300/300"),
                contentDescription = null
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = "https://picsum.photos/300/300")
                    .crossfade(true).build(),
                contentDescription = stringResource(id = R.string.description),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape)
            )
        }
        Row {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://picsum.photos/300/300")
                    .build(),
                contentDescription = stringResource(id = R.string.description),
            ) {
                val state = painter.state
                if (state is AsyncImagePainter.State.Loading) {
                    CircularProgressIndicator()
                } else {
                    SubcomposeAsyncImageContent(
                        modifier = Modifier.blur(
                            2.0.dp,
                            edgeTreatment = BlurredEdgeTreatment.Unbounded
                        ),
                        colorFilter = ColorFilter.lighting(Color.Gray, Color.Gray)
                    )
                }
            }
        }
    }
}

@Preview("Light Mode")
@Preview("Night Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ImageGreetingPreview() {
    JComposeTouristTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ImageGreeting()
        }
    }
}