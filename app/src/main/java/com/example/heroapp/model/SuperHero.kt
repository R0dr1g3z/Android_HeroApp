package com.example.heroapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero (
    @DrawableRes val image: Int,
    @StringRes val name: Int,
    @StringRes val description: Int
        )