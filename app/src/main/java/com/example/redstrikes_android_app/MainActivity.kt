package com.example.redstrikes_android_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.redstrikes_android_app.ui.screens.MovieDetailsScreen
import com.example.redstrikes_android_app.ui.screens.MovieListScreen
import com.example.redstrikes_android_app.ui.theme.MovieAppTheme
import com.example.redstrikes_android_app.navigation.NavRoutes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    topBar = {
                        when (currentRoute) {
                            NavRoutes.MOVIE_LIST -> MovieListTopAppBar()
                            NavRoutes.MOVIE_DETAILS -> MovieDetailsTopAppBar()
                        }
                    },
                    bottomBar = {
                        if (currentRoute != NavRoutes.MOVIE_DETAILS) {
                            BottomNavigationBar(navController, currentRoute)
                        }
                    }
                ) { padding ->
                    NavHost(
                        navController,
                        startDestination = NavRoutes.MOVIE_LIST,
                        modifier = Modifier.padding(padding)
                    ) {
                        composable(NavRoutes.MOVIE_LIST) {
                            MovieListScreen(navController = navController)
                        }
                        composable("${NavRoutes.MOVIE_DETAILS}/{movieId}") { backStackEntry ->
                            val movieId = backStackEntry.arguments?.getString("movieId")?.toIntOrNull()
                            MovieDetailsScreen(
                                navController = navController,
                                movieId = movieId
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListTopAppBar() {
    TopAppBar(
        title = { Text("Список фильмов") }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsTopAppBar() {
    TopAppBar(
        title = { Text("Movie Details") },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Share, contentDescription = "Share")
            }
        }
    )
}

@Composable
fun BottomNavigationBar(navController: androidx.navigation.NavController, currentRoute: String?) {
    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == NavRoutes.MOVIE_LIST,
            onClick = { navController.navigate(NavRoutes.MOVIE_LIST) { launchSingleTop = true } },
            icon = { Icon(Icons.Filled.Menu, contentDescription = "Фильмы") },
            label = { Text("Фильмы") }
        )
    }
}