package com.example.bankappchallenge.ui.composables.transfer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankappchallenge.R
import com.example.bankappchallenge.ui.theme.SetStatusBarColor

@Composable
fun TransferDetailsScreenPortrait() {
    SetStatusBarColor(color = MaterialTheme.colorScheme.primary)
    Box(modifier = Modifier.fillMaxSize()) {
        TransferDetailsScreen()
        TransferSendButton(
            label = "Send",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.BottomCenter)
        )
    }

}

@Composable
fun TransferDetailsScreen() {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier) {
            TopBarSectionTransfer(modifier = Modifier.padding(top = 16.dp))
            TransferReceiverDetails(modifier = Modifier.padding(top = 24.dp))
            TransferAmount(modifier = Modifier.padding(top = 32.dp))

            Text(
                text = "Select your account",
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onTertiary),
                modifier = Modifier.padding(top = 32.dp)
            )
            TransferAccountCard(
                modifier = Modifier
                    .padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun TransferReceiverDetails(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.png_avatar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(64.dp)
        )
        Text(
            text = "Nadia Page",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "3246 **** **** 3422",
            style = MaterialTheme.typography.bodySmall
        )

    }
}

@Composable
fun TransferAmount(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "$ 320.00",
            style = MaterialTheme.typography.labelLarge.copy(fontSize = 32.sp)
        )

        Text(
            text = "No fee",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun TransferAccountCard(modifier: Modifier = Modifier) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_mastercard),
                contentDescription = null,
                modifier = Modifier.size(56.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(text = "**** 2236", style = MaterialTheme.typography.titleSmall)
                Text(
                    text = "Balance: $ 5300.00",
                    style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.onTertiary)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun TransferSendButton(modifier: Modifier = Modifier, label: String) {
    Button(
        onClick = {},
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp)
    ) {
        Text(text = label, style = MaterialTheme.typography.labelMedium)
    }
}