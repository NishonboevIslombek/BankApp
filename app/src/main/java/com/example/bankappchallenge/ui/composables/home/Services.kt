package com.example.bankappchallenge.ui.composables.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bankappchallenge.R
import com.example.bankappchallenge.data.model.ServiceItem

@Composable
fun ServicesRow(modifier: Modifier = Modifier, onServiceClicked: (id: Int) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        testServiceList.forEach {
            ServiceElement(
                title = it.title,
                icon = it.icon,
                onServiceClicked = { onServiceClicked(it.id) }
            )
        }
    }
}

@Composable
private fun ServiceElement(
    @StringRes title: Int,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    onServiceClicked: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Service Payment",
            modifier = Modifier
                .size(64.dp)
                .shadow(
                    elevation = 6.dp,
                    shape = CircleShape,
                    spotColor = Color.Black,
                    ambientColor = Color.Gray
                )
                .background(color = Color.White, shape = CircleShape)
                .clickable { onServiceClicked() }
                .padding(20.dp)
        )
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

private val testServiceList = listOf(
    ServiceItem(
        id = 0,
        title = R.string.action_top_up,
        icon = R.drawable.ic_payment
    ),
    ServiceItem(
        id = 1,
        title = R.string.action_pay,
        icon = R.drawable.ic_receipt
    ),
    ServiceItem(
        id = 2,
        title = R.string.action_send,
        icon = R.drawable.ic_send
    ),
    ServiceItem(
        id = 3,
        title = R.string.action_more,
        icon = R.drawable.ic_table
    )
)