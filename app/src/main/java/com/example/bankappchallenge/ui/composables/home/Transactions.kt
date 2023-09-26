package com.example.bankappchallenge.ui.composables.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bankappchallenge.R
import com.example.bankappchallenge.ui.theme.MediumGray

@Composable
fun RecentTransactionsSection(modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        contentColor = Color.Black,
        shape = MaterialTheme.shapes.large,
        modifier = modifier
            .fillMaxSize()
            .shadow(8.dp, shape = MaterialTheme.shapes.extraLarge)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_maximize_gray),
                contentDescription = "Maximize",
                tint = MediumGray,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(50.dp)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Recent Transactions",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                    modifier = Modifier
                        .size(56.dp)
                        .padding(18.dp)
                )
            }

            TransactionsColumn()
        }
    }
}

@Composable
fun TransactionsColumn(modifier: Modifier = Modifier) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 6.dp),
        modifier = modifier
    ) {
        items(50) {
            TransactionElement()
        }
    }
}

@Composable
fun TransactionElement(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.png_avatar),
            contentDescription = "Transaction Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = "Netflix",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "Entertainment",
                style = MaterialTheme.typography.bodySmall
            )
        }
        Text(text = "- $ 10", style = MaterialTheme.typography.titleSmall)
    }
}