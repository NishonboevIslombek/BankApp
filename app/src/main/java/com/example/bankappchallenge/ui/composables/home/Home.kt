package com.example.bankappchallenge.ui.composables.home

import android.widget.Toast
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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


@Composable
fun HomePortrait(modifier: Modifier = Modifier, onServiceClicked: (id: Int) -> Unit) {
    Scaffold(bottomBar = { BottomNavigationBar() }) { padding ->
        HomeScreen(
            modifier = Modifier
                .padding(padding), onServiceClicked = { onServiceClicked(it) }
        )
    }
}

@Composable
fun HomeScreen(modifier: Modifier, onServiceClicked: (id: Int) -> Unit) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        if (maxHeight < 600.dp) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                TopBarSection(modifier = Modifier.padding(top = 16.dp))
                MyCardsRow(modifier = Modifier.padding(top = 16.dp))
                ServicesRow(
                    modifier = Modifier.padding(top = 28.dp),
                    onServiceClicked = { onServiceClicked(it) })
            }
            RecentTransactionsSection(sheetPeakHeight = 200.dp)
        } else if (maxHeight > 600.dp && maxHeight < 800.dp) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                TopBarSection(modifier = Modifier.padding(top = 16.dp))
                MyCardsRow(modifier = Modifier.padding(top = 32.dp))
                ServicesRow(
                    modifier = Modifier.padding(top = 48.dp),
                    onServiceClicked = { onServiceClicked(it) })
            }
            RecentTransactionsSection(sheetPeakHeight = 300.dp)
        } else {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                TopBarSection(modifier = Modifier.padding(top = 16.dp))
                MyCardsRow(modifier = Modifier.padding(top = 32.dp))
                ServicesRow(
                    modifier = Modifier.padding(top = 48.dp),
                    onServiceClicked = { onServiceClicked(it) })
            }
            RecentTransactionsSection(sheetPeakHeight = 400.dp)
        }
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
