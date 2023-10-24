package com.example.bankappchallenge.data

sealed class Navigation(val route: String) {
    object MainScreen : Navigation("main_screen")
    object TransferScreen : Navigation("transfer_screen")
    object TransferDetailsScreen : Navigation("transfer_details_screen")
    object TransferSuccessScreen : Navigation("transfer_success_screen")
}
