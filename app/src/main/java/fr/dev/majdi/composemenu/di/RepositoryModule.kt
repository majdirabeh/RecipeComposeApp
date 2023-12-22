package fr.dev.majdi.composemenu.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.dev.majdi.composemenu.data.network.ServiceApi
import fr.dev.majdi.composemenu.data.network.model.RecipeMapper
import fr.dev.majdi.composemenu.domain.repository.RecipeRepository
import fr.dev.majdi.composemenu.data.repository.RecipeRepositoryImpl
import javax.inject.Singleton

/**
 * Created by Majdi RABEH on 09/07/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        serviceApi: ServiceApi,
        recipeMapper: RecipeMapper,
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            serviceApi = serviceApi,
            mapper = recipeMapper
        )
    }

}