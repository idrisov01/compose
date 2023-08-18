package com.idrisov.navigation.di

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object NavigationModule {

    @Composable
    fun provideNavHostController() = rememberNavController()
}