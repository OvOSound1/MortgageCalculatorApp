package com.example.mortgagecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                val vm: MortgageViewModel = viewModel()

                NavHost(navController, startDestination = "input") {
                    composable("result") {
                        ResultScreen(vm) {
                            navController.navigate("input")
                        }
                    }
                    composable("input") {
                        InputScreen(vm) {
                            vm.updateMortgage()
                            navController.navigate("result")
                        }
                    }
                }
            }
        }
    }
}
