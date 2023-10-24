package com.example.bankappchallenge.ui.composables.transfer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bankappchallenge.R
import com.example.bankappchallenge.ui.theme.SetStatusBarColor

@Composable
fun TransferDetailsScreenPortrait(onSendButtonClicked: () -> Unit, navController: NavController) {
    SetStatusBarColor(color = MaterialTheme.colorScheme.primary)
    Column(modifier = Modifier.fillMaxSize()) {
        TransferDetailsScreen(onBackPressed = {
            navController.navigateUp()
        }, modifier = Modifier.weight(1f))
        TransferSendButton(
            label = "Send",
            onClick = onSendButtonClicked,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
    }
}

@Composable
fun TransferDetailsScreen(modifier: Modifier = Modifier, onBackPressed: () -> Unit) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier) {
            TopBarSectionTransfer(
                modifier = Modifier.padding(top = 16.dp),
                onBackPressed = onBackPressed
            )
            TransferReceiverDetails(modifier = Modifier.padding(top = 24.dp))
            TransferAmount(modifier = Modifier.padding(top = 32.dp))

            Text(
                text = "Select your account",
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onTertiary),
                modifier = Modifier.padding(top = 32.dp)
            )
            TransferAccountCard()
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
fun TransferAccountCard(modifier: Modifier = Modifier, maxHeight: Int = 350) {
    val extended = remember { mutableStateOf(false) }
    val selectedAccount = remember { mutableIntStateOf(0) }
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .heightIn(max = maxHeight.dp)
    ) {
        AnimatedVisibility(!extended.value) {
            Box {
                TransferAccountCardElement(
                    onClickEnabled = false,
                    accountItem = testAccountList[selectedAccount.intValue],
                    onItemClicked = {}
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_down),
                    contentDescription = null,
                    modifier = Modifier
                        .size(56.dp)
                        .clickable(
                            onClick = { extended.value = true },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() })
                        .padding(16.dp)
                        .align(Alignment.CenterEnd)
                )
            }
        }
        AnimatedVisibility(
            visible = extended.value,
            enter = fadeIn() + expandVertically(expandFrom = Alignment.Top),
            exit = fadeOut() + shrinkVertically(shrinkTowards = Alignment.Top)
        ) {
            LazyColumn {
                itemsIndexed(testAccountList) { index, item ->
                    TransferAccountCardElement(
                        accountItem = item,
                        onItemClicked = {
                            selectedAccount.intValue = index
                            extended.value = false
                        })
                }
            }
        }
    }
}

@Composable
fun TransferAccountCardElement(
    modifier: Modifier = Modifier,
    onClickEnabled: Boolean = true,
    onItemClicked: () -> Unit,
    accountItem: AccountItem
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(72.dp)
            .clickable(onClick = onItemClicked, enabled = onClickEnabled)
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = accountItem.logo),
            contentDescription = null,
            modifier = Modifier.size(56.dp)
        )
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = "**** ${accountItem.cardNumber.split(" ")[3]}",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "Balance: $ ${accountItem.balance}",
                style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.onTertiary)
            )
        }
    }
}

@Composable
fun TransferSendButton(modifier: Modifier = Modifier, label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
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

data class AccountItem(
    val cardNumber: String,
    val balance: String,
    val logo: Int
)

val testAccountList = listOf(
    AccountItem("4545 3292 3029 3290", "300.00", R.drawable.ic_visa_cards_tool),
    AccountItem("5050 4141 1241 0012", "6000.00", R.drawable.logo_mastercard),
    AccountItem("4545 2141 3029 5111", "50.00", R.drawable.ic_visa_cards_tool),
    AccountItem("5050 3292 3029 1214", "2100.00", R.drawable.logo_mastercard),
    AccountItem("5155 3292 3029 2155", "170.00", R.drawable.ic_visa_cards_tool),

    )