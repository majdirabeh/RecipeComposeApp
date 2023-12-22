package fr.dev.majdi.composemenu.data.repository

import fr.dev.majdi.composemenu.domain.model.RecipeModel
import fr.dev.majdi.composemenu.data.network.ServiceApi
import fr.dev.majdi.composemenu.data.network.model.RecipeMapper
import fr.dev.majdi.composemenu.domain.repository.RecipeRepository


class RecipeRepositoryImpl (
    private val serviceApi: ServiceApi,
    private val mapper: RecipeMapper,
): RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<RecipeModel> {
        return mapper.toDomainList(serviceApi.search(token = token, page = page, query = query).recipes)
    }

}