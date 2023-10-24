package com.example.bankappchallenge.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ServiceItem(
    val id: Int,
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {
}