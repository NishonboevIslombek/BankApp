package com.example.bankappchallenge.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.example.bankappchallenge.R

// Set of Material typography styles to start with

val fontFamilyPoppinsMedium = FontFamily(
    Font(resId = R.font.poppins_medium)
)
val fontFamilyPoppinsSemiBold = FontFamily(
    Font(resId = R.font.poppins_semi_bold)
)
val fontFamilyPoppinsRegular = FontFamily(
    Font(resId = R.font.poppins_regular)
)

val Typography = Typography(

    labelLarge = TextStyle(
        fontFamily = fontFamilyPoppinsSemiBold,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),
    labelMedium = TextStyle(
        fontFamily = fontFamilyPoppinsMedium,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = fontFamilyPoppinsMedium,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    titleLarge = TextStyle(
        fontFamily = fontFamilyPoppinsSemiBold,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    titleMedium = TextStyle(
        fontFamily = fontFamilyPoppinsSemiBold,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.Black
    ),
    titleSmall = TextStyle(
        fontFamily = fontFamilyPoppinsSemiBold,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = fontFamilyPoppinsRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = fontFamilyPoppinsRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Gray
    )
)