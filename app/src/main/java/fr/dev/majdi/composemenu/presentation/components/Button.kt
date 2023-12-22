package fr.dev.majdi.composemenu.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.IosShare
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Created by Majdi RABEH on 22/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@Composable
fun ExtendedButton(modifier: Modifier, onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        modifier = modifier,
        onClick = { onClick() },
        icon = { Icon(Icons.Filled.IosShare, "Source") },
        text = { Text(text = "Source") },
    )
}