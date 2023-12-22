package fr.dev.majdi.composemenu.presentation.ui.recipe_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import fr.dev.majdi.composemenu.presentation.components.RecipeList
import fr.dev.majdi.composemenu.presentation.ui.theme.AppTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Majdi RABEH on 07/07/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val recipes = viewModel.recipes.value
                val loading = viewModel.loading.value
                val scaffoldState = rememberScaffoldState()
                //Change this value with food category want to be shown
                viewModel.query.value = FoodCategory.SOUP.value
                AppTheme(
                    displayProgressBar = loading,
                    darkTheme = false,
                ) {
                    Scaffold( topBar = {},
                        scaffoldState = scaffoldState,
                        snackbarHost = {
                            scaffoldState.snackbarHostState
                        },
                    ){
                        RecipeList(
                            loading = loading,
                            recipes = recipes
                        )
                    }
                }
            }
        }
    }


}