package com.kursatkumsuz.movie

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kursatkumsuz.movie.common.BottomNavigationBar
import com.kursatkumsuz.movie.navigation.NavGraph
import com.kursatkumsuz.util.Screen
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.foundation.layout.fillMaxSize

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.kursatkumsuz.ui.theme.MovieTheme {
                val navController = rememberNavController()
                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route


                var bottomBarState by rememberSaveable { (mutableStateOf(false)) }

                bottomBarState = when (currentRoute) {
                    Screen.HomeScreen.route -> true
                    Screen.WatchListScreen.route -> true
                    Screen.SearchScreen.route -> true
                    Screen.ProfileScreen.route -> true
                    else -> false
                }

                // Thêm xử lý ẩn bàn phím khi click ra ngoài input
                val focusManager = LocalFocusManager.current
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(
                            indication = null,
                            interactionSource = remember { androidx.compose.foundation.interaction.MutableInteractionSource() }
                        ) {
                            focusManager.clearFocus()
                        }
                ) {
                    Scaffold(
                        bottomBar = {
                            AnimatedVisibility(visible = bottomBarState) {
                                BottomNavigationBar(
                                    onItemClick = {
                                        navController.navigate(it) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    })
                            }
                        }
                    ) {
                        NavGraph(navController = navController)
                    }
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.R)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    com.kursatkumsuz.ui.theme.MovieTheme {
    }
}