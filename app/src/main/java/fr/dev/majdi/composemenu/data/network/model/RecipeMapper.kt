package fr.dev.majdi.composemenu.data.network.model

import fr.dev.majdi.composemenu.domain.model.RecipeModel
import fr.dev.majdi.composemenu.domain.util.DomainMapper

/**
 * Created by Majdi RABEH on 07/07/2023.
 * Email m.rabeh.majdi@gmail.com
 */
class RecipeMapper: DomainMapper<Recipe, RecipeModel> {
    override fun mapToDomainModel(model: Recipe): RecipeModel {
        return RecipeModel(
            id = model.pk,
            title = model.title,
            featuredImage = model.featuredImage,
            rating = model.rating,
            publisher = model.publisher,
            sourceUrl = model.sourceUrl,
            ingredients = model.ingredients,
            dateAdded = model.dateAdded,
            dateUpdated = model.dateUpdated,
        )
    }

    override fun mapFromDomainModel(domainModel: RecipeModel): Recipe {
        return Recipe(
            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            ingredients = domainModel.ingredients,
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated,
        )
    }

    fun toDomainList(initial: List<Recipe>): List<RecipeModel>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<RecipeModel>): List<Recipe>{
        return initial.map { mapFromDomainModel(it) }
    }

}