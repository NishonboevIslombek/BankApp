package com.example.bankappchallenge.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePortrait(modifier: Modifier = Modifier) {
    Scaffold(bottomBar = { BottomNavigationBar() }) {
        HomeScreen(modifier = Modifier.padding(it))
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier) {
        TopBarSection(modifier = Modifier.padding(top = 16.dp))
        MyCardsRow(modifier = Modifier.padding(top = 32.dp))
        ServicesRow(modifier = Modifier.padding(top = 48.dp))
        RecentTransactionsSection(modifier = Modifier.padding(top = 48.dp))
    }
}
