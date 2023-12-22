package fr.dev.majdi.composemenu.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import fr.dev.majdi.composemenu.domain.model.RecipeModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Majdi RABEH on 07/07/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@Composable
fun RecipeList(
    loading: Boolean,
    recipes: List<RecipeModel>
) {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
    ) {
        if (loading && recipes.isEmpty()) {
            HorizontalDottedProgressBar()
        } else if (recipes.isEmpty()) {
            NothingHere()
        } else {
            LazyColumn {
                itemsIndexed(
                    items = recipes
                ) { _, recipe ->
                    RecipeCard(
                        recipe = recipe,
                        onClick = {
                            //TODO To be implement
                        }
                    )
                }
            }
        }
    }
}