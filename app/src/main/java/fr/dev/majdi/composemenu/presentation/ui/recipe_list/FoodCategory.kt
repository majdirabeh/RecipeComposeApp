package fr.dev.majdi.composemenu.presentation.ui.recipe_list

import fr.dev.majdi.composemenu.presentation.ui.recipe_list.FoodCategory.BEEF
import fr.dev.majdi.composemenu.presentation.ui.recipe_list.FoodCategory.CHICKEN
import fr.dev.majdi.composemenu.presentation.ui.recipe_list.FoodCategory.DESSERT
import fr.dev.majdi.composemenu.presentation.ui.recipe_list.FoodCategory.DONUT
import fr.dev.majdi.composemenu.presentation.ui.recipe_list.FoodCategory.MILK
import fr.dev.majdi.composemenu.presentation.ui.recipe_list.FoodCategory.PIZZA
import fr.dev.majdi.composemenu.presentation.ui.recipe_list.FoodCategory.SOUP
import fr.dev.majdi.composemenu.presentation.ui.recipe_list.FoodCategory.VEGAN
import fr.dev.majdi.composemenu.presentation.ui.recipe_list.FoodCategory.VEGETARIAN

/**
 * Created by Majdi RABEH on 07/07/2023.
 * Email m.rabeh.majdi@gmail.com
 */
enum class FoodCategory(val value: String){
    CHICKEN("Chicken"),
    BEEF("Beef"),
    SOUP("Soup"),
    DESSERT("Dessert"),
    VEGETARIAN("Vegetarian"),
    MILK("Milk"),
    VEGAN("Vegan"),
    PIZZA("Pizza"),
    DONUT("Donut"),
}

fun getAllFoodCategories(): List<FoodCategory>{
    return listOf(CHICKEN, BEEF, SOUP, DESSERT, VEGETARIAN, MILK, VEGAN, PIZZA, DONUT)
}

fun getFoodCategory(value: String): FoodCategory? {
    val map = FoodCategory.values().associateBy(FoodCategory::value)
    return map[value]
}