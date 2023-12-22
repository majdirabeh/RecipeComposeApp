package fr.dev.majdi.composemenu.data.network

import fr.dev.majdi.composemenu.data.network.model.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Created by Majdi RABEH on 07/07/2023.
 * Email m.rabeh.majdi@gmail.com
 */
interface ServiceApi {

    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): RecipeSearchResponse

}