package com.example.bankappchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.bankappchallenge.ui.composables.transfer.TransferAccountCard
import com.example.bankappchallenge.ui.composables.transfer.TransferDetailsScreenPortrait
import com.example.bankappchallenge.ui.composables.transfer.TransferSuccessScreenPortrait
import com.example.bankappchallenge.ui.theme.BankAppChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankAppChallengeTheme {
                Surface(color = MaterialTheme.colorScheme.primary) {
                    TransferSuccessScreenPortrait()
                }
            }
        }
    }
}


