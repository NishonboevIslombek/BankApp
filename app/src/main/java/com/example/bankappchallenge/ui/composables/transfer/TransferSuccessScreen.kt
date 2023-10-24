package com.example.bankappchallenge.ui.composables.transfer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bankappchallenge.R
import com.example.bankappchallenge.ui.theme.SetStatusBarColor

@Composable
fun TransferSuccessScreenPortrait(onCloseClicked: () -> Unit) {
    SetStatusBarColor(color = MaterialTheme.colorScheme.primary)
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            TransferSuccessMassage()
            TransferSuccessButton(
                onClick = onCloseClicked,
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .padding(bottom = 22.dp)
            )
        }
    }
}

@Composable
fun TransferSuccessMassage(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(bottom = 200.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_success),
            contentDescription = null,
            modifier = Modifier.size(140.dp)
        )

        Text(
            text = "$ 320 has been \n sent to Nadia!",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(top = 32.dp)
        )
    }

}

@Composable
fun TransferSuccessButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "View receipt",
            style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.secondary),
            modifier = Modifier.padding(bottom = 32.dp)
        )
        TransferSendButton(label = "Close", onClick = onClick)
    }
}
