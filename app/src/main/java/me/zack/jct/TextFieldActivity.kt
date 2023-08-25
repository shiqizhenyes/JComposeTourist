package me.zack.jct

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.zack.jct.ui.theme.JComposeTouristTheme

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JComposeTouristTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextFieldGreeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldGreeting(name: String, modifier: Modifier = Modifier) {
    var text by remember {
        mutableStateOf("")
    }
    var passwordHidden by remember {
        mutableStateOf(false)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = text, onValueChange = {
            text = it
        }, singleLine = true,
            label = {
                Text(text = "邮箱")
            })
        TextField(value = text, onValueChange = {
            text = it
        },
            leadingIcon = {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            })
        TextField(value = text, onValueChange = {
            text = it
        },
            leadingIcon = {
                Text(text = "联系人")
            })
        TextField(value = text, onValueChange = {
            text = it
        },
            trailingIcon = {
                Text(text = "@163.com")
            })
        TextField(
            value = text, onValueChange = {
                text = it
            },
            leadingIcon = {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF0079D3),
                containerColor = Color.Transparent
            )
        )
        TextField(
            value = text, onValueChange = {
                text = it
            },
            label = {
                Text(text = "密码")
            },
            trailingIcon = {
                IconButton(onClick = {
                    passwordHidden = !passwordHidden
                }) {
                    Icon(
                        if (passwordHidden) painterResource(id = R.drawable.eye_slash) else painterResource(
                            id = R.drawable.eye
                        ), contentDescription = "",
                        modifier = Modifier.size(14.dp)
                    )
                }
            },
            visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None
        )
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Box(modifier = Modifier.fillMaxWidth()
            .background(Color.Transparent),
            contentAlignment = Alignment.Center) {
            BasicTextField(value = text, onValueChange = {
                text = it
            },
                modifier = Modifier
                    .background(color = Color.Transparent, CircleShape)
                    .height(35.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(
                    color = Color.White,
                    background = Color.Red
                ),
                decorationBox = { innerTextField ->
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        modifier = Modifier.padding(horizontal = 10.0.dp)
//                    ) {
//                        IconButton(onClick = { }) {
//                            Icon(
//                                painter = painterResource(id = R.drawable.mood),
//                                contentDescription = ""
//                            )
//                        }
//                        Box(
//                            modifier = Modifier.weight(1f),
//                            contentAlignment = Alignment.CenterStart
//                        ) {
                            innerTextField
//                        }
//                        IconButton(onClick = { }) {
//                            Icon(Icons.Filled.Send, contentDescription = "Send")
//                        }
//                    }
                }
            )
        }
    }
}

@Preview("Light Mode")
@Preview("Night Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextFieldGreetingPreview() {
    JComposeTouristTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            TextFieldGreeting("Android")
        }
    }
}