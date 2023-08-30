package me.zack.jct

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import me.zack.jct.ui.theme.JComposeTouristTheme

class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JComposeTouristTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScaffoldGreeting("Android")
                }
            }
        }
    }
}

@Composable
fun AppContent(itemTitle: String, modifier: Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "当前界面是$itemTitle")
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppDrawContent(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Draw top background"
        )
        Column(modifier = Modifier.padding(15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.avatar), contentDescription = "Avatar",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(65.dp)
                    .border(BorderStroke(1.dp, Color.Gray), CircleShape)
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = "游客12345", style = MaterialTheme.typography.bodyMedium)
        }
    }
    ListItem(
        icon = {
            Icon(Icons.Filled.Home, contentDescription = "Home")
        },
        modifier = Modifier.clickable {

        }
    ) {
        Text(text = "首页")
    }
    Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.BottomStart) {
        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.textButtonColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Icon(Icons.Filled.Settings, contentDescription = "Settings")
            Text(text = "设置")
        }
    }
    BackHandler(enabled = scaffoldState.drawerState.isOpen) {
        scope.launch {
            scaffoldState.drawerState.close()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldGreeting(name: String, modifier: Modifier = Modifier) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var selectedItem by remember {
        mutableIntStateOf(0)
    }
    val items = listOf("主页", "我喜欢的", "设置")
    var icon: ImageVector = Icons.Filled.Home
    var iconDescription: String = "Home"
    ModalNavigationDrawer(drawerContent = {
        AppDrawContent(
            scaffoldState = scaffoldState,
            scope = scope
        )
    }) {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(text = "魔卡沙的炼金工坊")
                },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    })
            },
            bottomBar = {
                BottomAppBar {
                    items.forEachIndexed { index, s ->
                        BottomNavigationItem(
                            selected = selectedItem == index,
                            onClick = {
                                selectedItem = index
                            },
                            icon = {
                                when (index) {
                                    0 -> {
                                        icon = Icons.Filled.Home
                                        iconDescription = "Home"
                                    }

                                    1 -> {
                                        icon = Icons.Filled.Favorite
                                        iconDescription = "Favorite"
                                    }

                                    2 -> {
                                        icon = Icons.Filled.Settings
                                        iconDescription = "Settings"
                                    }
                                }
                                Icon(icon, contentDescription = iconDescription)
                            }, label = {
                                Text(text = s, fontSize = 14.sp)
                            })
                    }
                }
            },
            content = {
                AppContent(items[selectedItem], modifier)
            }
        )
    }
}

@Preview("Light Mode")
@Preview("Night Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ScaffoldGreetingPreview5() {
    JComposeTouristTheme {
        ScaffoldGreeting("Android")
    }
}