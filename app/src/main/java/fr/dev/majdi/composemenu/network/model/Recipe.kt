package fr.dev.majdi.composemenu.network.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Majdi RABEH on 07/07/2023.
 * Email m.rabeh.majdi@gmail.com
 */
data class Recipe(
    @SerializedName("pk") var pk: Int,
    @SerializedName("title") var title: String,
    @SerializedName("publisher") var publisher: String,
    @SerializedName("featured_image") var featuredImage: String,
    @SerializedName("rating") var rating: Int = 0,
    @SerializedName("source_url") var sourceUrl: String,
    @SerializedName("ingredients") var ingredients: List<String> = emptyList(),
    @SerializedName("date_added") var dateAdded: String,
    @SerializedName("date_updated") var dateUpdated: String,
)