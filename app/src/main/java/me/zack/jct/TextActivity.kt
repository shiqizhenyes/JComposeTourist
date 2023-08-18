package me.zack.jct

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
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
    val context = LocalContext.current
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.secondary
            )
        ) {
            append("勾选即代表同意")
        }
        pushStringAnnotation(tag = "tag", annotation = "一个用户协议啦啦啦，内容内容")
        withStyle(
            style = SpanStyle(
                color = Color(0xFF0E9FF2),
                fontWeight = FontWeight.Bold
            )
        ) {
            append("用户协议")
        }
        pop()
    }
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
        Text(
            text = "在朋友家度过的一天，我们畅谈了许多美好的事情，由衷的庆幸大家似乎对未来有了更好的期待",
            fontFamily = FontFamily(Font(R.font.firasans_bold, FontWeight.W700))
        )
        Text(text = "确认编辑", Modifier.clickable {
            Toast.makeText(context, "你点击了此文本", Toast.LENGTH_LONG).show()
        })
        Text(text = buildAnnotatedString {
            append("你现在观看的章节是")
            withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                append("国风·周南")
            }
        })
        ClickableText(text = annotatedText, onClick = { offset ->
            annotatedText.getStringAnnotations(tag = "tag", start = offset, end = offset)
                .firstOrNull().let { annotation ->
                    Log.d(TextActivity::class.simpleName, "Hi，你按到了${annotation?.item}了")
            }
//            Log.d(TextActivity::class.simpleName, "Hi，你按到了第 $offset 位的文字")
        })
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.alfred_sisley),
                contentDescription = "alfred sisley",
                modifier = Modifier
                    .clip(RoundedCornerShape(80.dp))
                    .size(80.dp),
                contentScale = ContentScale.Crop
            )
            Column {

            }
        }
    }
}

@Preview("Light Mode")
@Preview("Night Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TextGreetingPreview() {
    JComposeTouristTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            TextGreeting("Android")
        }
    }
}