package fr.dev.majdi.composemenu.repository

import fr.dev.majdi.composemenu.domain.model.RecipeModel

interface RecipeRepository {
    suspend fun search(token: String, page: Int, query: String): List<RecipeModel>
}
