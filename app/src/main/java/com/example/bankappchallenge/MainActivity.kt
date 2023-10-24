package com.example.bankappchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bankappchallenge.data.Navigation.*
import com.example.bankappchallenge.ui.composables.home.HomePortrait
import com.example.bankappchallenge.ui.composables.transfer.TransferDetailsScreenPortrait
import com.example.bankappchallenge.ui.composables.transfer.TransferScreenPortrait
import com.example.bankappchallenge.ui.composables.transfer.TransferSuccessScreenPortrait
import com.example.bankappchallenge.ui.theme.BankAppChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankAppChallengeTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = MainScreen.route) {
        composable(MainScreen.route) {
            HomePortrait(onServiceClicked = {
                when (it) {
                    0 -> navController.navigate(TransferScreen.route)
                    1 -> navController.navigate(TransferScreen.route)
                    2 -> navController.navigate(TransferScreen.route)
                    3 -> navController.navigate(TransferScreen.route)
                }
            })
        }
        composable(TransferScreen.route) {
            TransferScreenPortrait(
                onReceiverClicked = {
                    navController.navigate(TransferDetailsScreen.route)
                }, navController = navController
            )
        }
        composable(TransferDetailsScreen.route) {
            TransferDetailsScreenPortrait(onSendButtonClicked = {
                navController.navigate(TransferSuccessScreen.route)
            }, navController = navController)
        }
        composable(TransferSuccessScreen.route) {
            TransferSuccessScreenPortrait(onCloseClicked = {
                navController.navigate(MainScreen.route) {
                    popUpTo(MainScreen.route) { inclusive = true }
                    launchSingleTop = true
                }
            })
        }
    }
}


