package com.example.navcontroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navcontroller.View.Home
import com.example.navcontroller.View.Profile
import com.example.navcontroller.ui.theme.NavControllerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavControllerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ){

                        composable(route = "home") {
                            Scaffold(
                                bottomBar = {
                                    BottomBar(
                                        navController = navController
                                    )
                                },
                            ) { contentPadding ->

                                Home()
                            }

                        }

                        composable(route="profile"){
                            Scaffold(
                                bottomBar = {
                                    BottomBar(
                                        navController = navController
                                    )
                                },
                            ) { contentPadding ->
                                Profile()
                            }
                        }
                    }

                }
            }
        }
    }
}

