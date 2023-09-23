package com.example.bankappchallenge

import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.example.bankappchallenge.ui.composables.BottomNavigationBar
import com.example.bankappchallenge.ui.composables.HomePortrait
import com.example.bankappchallenge.ui.composables.HomeScreen
import com.example.bankappchallenge.ui.composables.MyCardsRow
import com.example.bankappchallenge.ui.composables.RecentTransactionsSection
import com.example.bankappchallenge.ui.composables.ServicesRow
import com.example.bankappchallenge.ui.composables.TopBarSection
import com.example.bankappchallenge.ui.theme.BankAppChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankAppChallengeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    HomePortrait()
                }
            }
        }
    }
}


