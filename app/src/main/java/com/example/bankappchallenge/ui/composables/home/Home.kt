package com.example.bankappchallenge.ui.composables.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bankappchallenge.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePortrait(modifier: Modifier = Modifier) {
    Scaffold(bottomBar = { BottomNavigationBar() }) {
        HomeScreen(
            modifier = Modifier
                .padding(it)
        )
    }
}

@Composable
fun HomeScreen(modifier: Modifier) {
    Column(
        modifier = Modifier
    ) {
        TopBarSection(modifier = Modifier.padding(top = 16.dp))
        MyCardsRow(modifier = Modifier.padding(top = 32.dp))
        ServicesRow(modifier = Modifier.padding(top = 48.dp))
        RecentTransactionsSection(modifier = Modifier.padding(top = 48.dp))
    }
}

@Composable
fun TopBarSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = "My Accounts",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_alert),
            contentDescription = "Notification",
            modifier = Modifier
                .size(24.dp)
        )
    }
}
