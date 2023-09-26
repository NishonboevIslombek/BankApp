package com.example.bankappchallenge.ui.composables.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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

@Composable
fun ServicesRow(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        ServiceElement(title = R.string.action_top_up, icon = R.drawable.ic_payment)
        ServiceElement(title = R.string.action_pay, icon = R.drawable.ic_receipt)
        ServiceElement(title = R.string.action_send, icon = R.drawable.ic_send)
        ServiceElement(title = R.string.action_more, icon = R.drawable.ic_table)
    }
}

@Composable
fun ServiceElement(@StringRes title: Int, @DrawableRes icon: Int, modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
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
                .padding(20.dp)
        )
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}