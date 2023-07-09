package fr.dev.majdi.composemenu.presentation.ui.recipe_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.dev.majdi.composemenu.domain.model.RecipeModel
import fr.dev.majdi.composemenu.repository.RecipeRepository
import fr.dev.majdi.composemenu.utils.TAG
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Majdi RABEH on 07/07/2023.
 * Email m.rabeh.majdi@gmail.com
 */

@HiltViewModel
class RecipeListViewModel @Inject
constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String
) : ViewModel() {


    val recipes: MutableState<List<RecipeModel>> = mutableStateOf(ArrayList())
    val loading = mutableStateOf(false)
    val query = mutableStateOf("Milk")

    init {
        searchRecipes()
    }

    private suspend fun getRecipes() {
        loading.value = true
        delay(2000)

        val result = repository.search(
            token = token,
            page = 1,
            query = query.value
        )
        recipes.value = result
        loading.value = false
    }

    private fun searchRecipes(){
        viewModelScope.launch {
            try {
                getRecipes()
            }catch (e: Exception){
                Log.e(TAG, "Exception: ${e}, ${e.cause}")
                e.printStackTrace()
            }
            finally {
                Log.d(TAG, "finally called.")
            }
        }
    }


}