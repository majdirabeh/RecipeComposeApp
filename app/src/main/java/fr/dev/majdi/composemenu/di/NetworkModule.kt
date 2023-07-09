package fr.dev.majdi.composemenu.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.dev.majdi.composemenu.network.ServiceApi
import fr.dev.majdi.composemenu.network.model.RecipeMapper
import fr.dev.majdi.composemenu.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Majdi RABEH on 09/07/2023.
 * Email m.rabeh.majdi@gmail.com
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeMapper(): RecipeMapper {
        return RecipeMapper()
    }

    @Singleton
    @Provides
    fun provideRecipeService(): ServiceApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ServiceApi::class.java)
    }

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken(): String{
        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }

}