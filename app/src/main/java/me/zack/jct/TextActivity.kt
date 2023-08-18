package me.zack.jct

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.zack.jct.ui.theme.JComposeTouristTheme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JComposeTouristTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextGreeting("Android")
                }
            }
        }
    }
}

@Composable
fun TextGreeting(name: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(text = "你好呀陌生人，这是一个标题", style = MaterialTheme.typography.titleLarge)
        Text(text = "你好呀陌生人，我的是内容", style = MaterialTheme.typography.bodyLarge)
        Text(text = stringResource(id = R.string.content))
        Text(
            text = stringResource(id = R.string.content2), style = TextStyle(
                fontWeight = FontWeight.W900,
                fontSize = 20.0.sp,
                letterSpacing = 7.sp
            )
        )
        Text(
            text = stringResource(id = R.string.content3),
            style = MaterialTheme.typography.titleSmall,
            maxLines = 1
        )
        Text(
            text = stringResource(id = R.string.content).plus(stringResource(id = R.string.content2)),
            maxLines = 1, overflow = TextOverflow.Ellipsis
        )
        Text(
            text = stringResource(id = R.string.content).plus(stringResource(id = R.string.content2)),
            maxLines = 1, overflow = TextOverflow.Visible
        )
        Text(
            text = "每天摸鱼", modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Text(text = "这好吗", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Text(text = "这非常的好", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.End)
        Text(
            text = "我也觉得这非常好非常好非常好非常好非常好非常好非常好非常好非常好非常好",
            modifier = Modifier.size(300.0.dp, 80.dp),
            textAlign = TextAlign.Justify
        )
        Text(text = "两面包夹芝士".repeat(15))
        Spacer(modifier = Modifier.padding(15.dp))
        Text(text = "两面包夹芝士".repeat(15), lineHeight = 30.sp)
        Text(text = "在朋友家度过的一天，我们畅谈了许多美好的事情，由衷的庆幸大家似乎对未来有了更好的期待",
            fontFamily = FontFamily(Font(R.font.firasans_bold, FontWeight.W700))
        )
        Text(text = "确认编辑", Modifier.clickable {

        })
    }
}

@Preview("Light Mode")
@Preview("Night Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview2() {
    JComposeTouristTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            TextGreeting("Android")
        }
    }
}