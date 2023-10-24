package com.example.bankappchallenge.ui.composables.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bankappchallenge.R
import com.example.bankappchallenge.ui.theme.MediumGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecentTransactionsSection(modifier: Modifier = Modifier, sheetPeakHeight: Dp) {
    BottomSheetScaffold(
        modifier = Modifier.nestedScroll(TopAppBarDefaults.enterAlwaysScrollBehavior().nestedScrollConnection),
        sheetContent = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
            ) {
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
        },
        sheetDragHandle = {
            Icon(
                painter = painterResource(id = R.drawable.ic_maximize_gray),
                contentDescription = "Maximize",
                tint = MediumGray,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(50.dp)
            )
        },
        scaffoldState = rememberBottomSheetScaffoldState(),
        sheetPeekHeight = sheetPeakHeight
    ) {

    }
}

@Composable
fun TransactionsColumn(modifier: Modifier = Modifier) {
    val lazyColumnState = rememberLazyListState()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 6.dp),
        state = lazyColumnState,
        modifier = modifier
    ) {
        items(50) {
            TransactionElement(id = it)
        }
    }
}

@Composable
fun TransactionElement(modifier: Modifier = Modifier, id: Int) {
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
                text = "Netflix $id",
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