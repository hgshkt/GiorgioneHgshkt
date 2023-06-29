package com.hgshkt.giorgionehgshkt.di

import com.hgshkt.giorgionehgshkt.ui.screens.profile.ProfileViewModel
import com.hgshkt.giorgionehgshkt.ui.screens.search.SearchViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@EntryPoint
@InstallIn(ActivityComponent::class)
interface ViewModelFactoryProvider {
    fun profileViewModelFactory(): ProfileViewModel.Factory

    fun searchViewModelFactory(): SearchViewModel.Factory
}