package me.zack.jct

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import me.zack.jct.entity.Element
import me.zack.jct.mode.ElementData
import me.zack.jct.ui.theme.JComposeTouristTheme

class ElementsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JComposeTouristTheme {
                Surface {
                    ElementGreeting(ElementData.elements)
                }
            }
        }
    }

}

@Composable
fun OpenAlertDialog() {
    val openDialog = remember {
        mutableStateOf(true)
    }
    if (openDialog.value) {
        AlertDialog(onDismissRequest = { openDialog.value = false }, confirmButton = {
            TextButton(onClick = { openDialog.value = false }) {
                Text(
                    text = "确认",
                    fontWeight = FontWeight.W700,
                    style = MaterialTheme.typography.displayMedium
                )
            }
        },
            dismissButton = {
                            TextButton(onClick = {
                                openDialog.value = false
                            }) {
                                Text(
                                    text = "取消",
                                    fontWeight = FontWeight.W700,
                                    style = MaterialTheme.typography.displayMedium
                                )
                            }
            },
            title = {
                Text(text = "开启位置服务", fontWeight = FontWeight.W700,
                    style = MaterialTheme.typography.titleMedium
                )
            },
            text = {
                Text(text = "这将意味着，我们会给您提供精准的位置服务，并且您将接受关于您订阅的位置信息",
                    fontSize = 16.0.sp)
            })
    }
}


@Composable
fun OnElementAction(elementName: String) {
    when(elementName) {
        "AlertDialog" -> {
            OpenAlertDialog()
        }
    }
}

@Composable
fun ElementConversation(elements: List<Element>) {
    LazyRow() {
        items(elements) { item: Element ->
            Button(onClick = {
//                Toast.makeText(, R.string.app_name, Toast.LENGTH_LONG).show
//                OnElementAction(elementName = item.name)
            }) {
                Text(text = item.name)
            }
        }
    }
}


@Composable
fun ElementGreeting(elements: List<Element>) {
    ElementConversation(elements = elements)
}

@Preview(name = "Light Mode")
@Preview(name = "Night Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ElementDialogPreview() {
    JComposeTouristTheme {
        Surface {
            OpenAlertDialog()
        }
    }
}


@Preview(name = "Light Mode")
@Preview(name = "Night Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ElementGreetingPreview() {
    JComposeTouristTheme {
        Surface {
            ElementGreeting(ElementData.elements)
        }
    }
}