package com.islam.cleannavigation.di

import com.islam.cleannavigation.navigation_utils.AppNavigator
import com.islam.cleannavigation.navigation_utils.AppNavigatorIMPI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Singleton
    @Binds
    fun bindAppModule(appNavigatorIMPI: AppNavigatorIMPI): AppNavigator
}