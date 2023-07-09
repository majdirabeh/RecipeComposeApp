package fr.dev.majdi.composemenu.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.dev.majdi.composemenu.presentation.App
import javax.inject.Singleton

/**
 * Created by Majdi RABEH on 09/07/2023.
 * Email m.rabeh.majdi@gmail.com
 */

//@Module
//@InstallIn(SingletonComponent ::class)
//object AppModule {
//
//    @Singleton
//    @Provides
//    fun provideApplication(@ApplicationContext app: Context): App {
//        return app as App
//    }
//
//}