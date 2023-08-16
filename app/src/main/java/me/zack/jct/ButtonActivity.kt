package me.zack.jct

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.zack.jct.entity.ButtonState
import me.zack.jct.ui.theme.JComposeTouristTheme

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JComposeTouristTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ButtonGreeting()
                }
            }
        }
    }
}




@Composable
fun ButtonFavorite() {
    val interactionState = remember {
        MutableInteractionSource()
    }
    val (text, textColor, buttonColor) = when {
        interactionState.collectIsPressedAsState().value -> ButtonState("Just Pressed", Color.Red, Color.Black)
        else -> ButtonState("Just Button", Color.White, Color.Red)
    }
    Button(onClick = { /*TODO*/ },
        interactionSource = interactionState,
        elevation = null,
        shape = RoundedCornerShape(50.0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = textColor,
        )
    ) {
        Icon(Icons.Filled.Favorite, contentDescription = "喜欢", Modifier.size(ButtonDefaults.IconSize))
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = text, color = textColor)
    }
}


@Composable
fun FloatActionButton() {
    Row {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
        }
        ExtendedFloatingActionButton(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(50.0.dp)
        ) {
            Icon(Icons.Filled.Add, "Localized description")
            Text(text = "Extended FAB")
        }
        ExtendedFloatingActionButton(onClick = { /*TODO*/ },
            shape = FloatingActionButtonDefaults.largeShape
        ) {
            Icon(Icons.Filled.Add, "Localized description")
        }
    }
}


@Composable
fun IconSample() {
    Column {
        Row {
            Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_favorite),
                contentDescription = "矢量图资源")
            Icon(bitmap = ImageBitmap.imageResource(R.drawable.ic_favorite_png),
                contentDescription = "图片资源", modifier = Modifier.size(24.dp))
            Icon(painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = "任意类型资源")
        }
        Row {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "ArrowBack")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Done, contentDescription = "Done")
            }
            MyIconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.ArrowForward, contentDescription = "Done")
            }
        }
        AWorldCard()
    }
}

@Composable
fun MyIconButton(onClick: () -> Unit,
                 modifier: Modifier = Modifier,
                 enabled: Boolean = true,
                 interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
                 content: @Composable () -> Unit
) {
    // 这也是源码的一部分
    val IconButtonSizeModifier = Modifier.size(48.dp)
    Box(
        modifier = modifier
            .clickable(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = null
            )
            .then(IconButtonSizeModifier),
        contentAlignment = Alignment.Center
    ) { content() }
}


@Composable
fun AWorldCard() {
    Surface(
        modifier = Modifier.padding(40.0.dp),
        shape = RoundedCornerShape(20.0.dp),
        shadowElevation = 5.0.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFBED4D0))
                    .fillMaxWidth()
                    .padding(20.0.dp, 40.0.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    text = "一言",
                    fontWeight = FontWeight.W700,
                    fontSize = 50.0.sp,
                    color = Color.Black
                )
            }
            Spacer(Modifier.height(20.0.dp))
            Text(
                text = "“", fontWeight = FontWeight.W700,
                modifier = Modifier.padding(10.0.dp),
                lineHeight = 60.0.sp,
                fontSize = 50.sp, color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = "把同班同学娶回家就是\n我最大的梦想",
                modifier = Modifier.padding(10.0.dp),
                fontWeight = FontWeight.W700,
                lineHeight = 30.0.sp,
                fontSize = 26.sp,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = "”", fontWeight = FontWeight.W700,
                lineHeight = 60.0.sp,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.0.dp),
                fontSize = 50.sp, color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}


@Composable
fun ButtonGreeting() {
    Column {
        ButtonFavorite()
        FloatActionButton()
        IconSample()
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Night Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ButtonGreetingPreview() {
    JComposeTouristTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ButtonGreeting()
        }
    }
}