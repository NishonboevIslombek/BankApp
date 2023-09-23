package com.example.bankappchallenge.ui.composables

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bankappchallenge.R
import com.example.bankappchallenge.ui.theme.fontFamilyPoppinsRegular

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        tonalElevation = 0.dp,
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))

    ) {
        NavigationBarItem(
            selected = true,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.White,
                selectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = MaterialTheme.colorScheme.secondary,
                unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                unselectedTextColor = MaterialTheme.colorScheme.onSecondary
            ),
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_wallet),
                    contentDescription = "Accounts",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = "Accounts",
                    style = MaterialTheme.typography.labelSmall.copy(fontFamily = fontFamilyPoppinsRegular)
                )
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.White,
                selectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = MaterialTheme.colorScheme.secondary,
                unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                unselectedTextColor = MaterialTheme.colorScheme.onSecondary
            ),
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_data_pie),
                    contentDescription = "Statics",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = "Statics",
                    style = MaterialTheme.typography.labelSmall.copy(fontFamily = fontFamilyPoppinsRegular)
                )
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.White,
                selectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = MaterialTheme.colorScheme.secondary,
                unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                unselectedTextColor = MaterialTheme.colorScheme.onSecondary
            ),
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_gift),
                    contentDescription = "Cashback",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = "Cashback",
                    style = MaterialTheme.typography.labelSmall.copy(fontFamily = fontFamilyPoppinsRegular)
                )
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.White,
                selectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = MaterialTheme.colorScheme.secondary,
                unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                unselectedTextColor = MaterialTheme.colorScheme.onSecondary
            ),
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_settings),
                    contentDescription = "Settings",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.labelSmall.copy(fontFamily = fontFamilyPoppinsRegular)
                )
            }
        )
    }
}

