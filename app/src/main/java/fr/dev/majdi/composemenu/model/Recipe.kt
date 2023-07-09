package fr.dev.majdi.composemenu.model

import androidx.annotation.DrawableRes

/**
 * Created by Majdi RABEH on 05/07/2023.
 * Email m.rabeh.majdi@gmail.com
 */
data class Recipe(
    @DrawableRes val imageResource: Int,
    val title: String,
    val ingredients: List<String>
)