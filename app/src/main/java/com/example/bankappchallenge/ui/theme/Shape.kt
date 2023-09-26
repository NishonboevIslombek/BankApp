package com.example.bankappchallenge.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val shapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
    large = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
)