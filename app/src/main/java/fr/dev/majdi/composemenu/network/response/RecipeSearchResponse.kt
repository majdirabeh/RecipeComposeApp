package fr.dev.majdi.composemenu.network.response

import com.google.gson.annotations.SerializedName
import fr.dev.majdi.composemenu.network.model.Recipe

/**
 * Created by Majdi RABEH on 07/07/2023.
 * Email m.rabeh.majdi@gmail.com
 */
class RecipeSearchResponse (
    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<Recipe>,
)