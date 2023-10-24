package com.example.bankappchallenge.ui.composables.transfer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bankappchallenge.R
import com.example.bankappchallenge.ui.theme.SetStatusBarColor

@Composable
fun TransferScreenPortrait(
    modifier: Modifier = Modifier,
    onReceiverClicked: (id: Int) -> Unit,
    navController: NavController
) {
    //TODO:Change SetStatusBarColor function
    SetStatusBarColor(color = MaterialTheme.colorScheme.primary)
    Surface(modifier = modifier.fillMaxSize()) {
        Column {
            TopBarSectionTransfer(
                modifier = Modifier.padding(top = 16.dp),
                onBackPressed = { navController.navigateUp() })

            SearchBarSection(modifier = Modifier.padding(top = 32.dp))
            ReceiversColumn(onReceiverClicked = onReceiverClicked)

        }
    }
}

@Composable
fun TopBarSectionTransfer(modifier: Modifier = Modifier, onBackPressed: () -> Unit) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_left),
            contentDescription = null,
            modifier = Modifier
                .clickable { onBackPressed() }
                .size(56.dp)
                .padding(16.dp)
        )
        Text(
            text = "Send money to",
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun SearchBarSection(modifier: Modifier = Modifier) {
    TextField(
        textStyle = MaterialTheme.typography.bodyMedium,
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        },
        placeholder = {
            Text(
                text = "Write name, phone or card number"
            )
        },
        shape = MaterialTheme.shapes.small,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.tertiary,
            unfocusedContainerColor = MaterialTheme.colorScheme.tertiary,
            focusedTextColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
            focusedPlaceholderColor = MaterialTheme.colorScheme.onTertiary,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.onTertiary,
            focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
            selectionColors = TextSelectionColors(
                handleColor = MaterialTheme.colorScheme.secondary,
                backgroundColor = MaterialTheme.colorScheme.onSecondary
            ),
            cursorColor = MaterialTheme.colorScheme.secondary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),

        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp)
    )
}

