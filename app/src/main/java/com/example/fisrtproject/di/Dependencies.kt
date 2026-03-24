package com.example.fisrtproject.di

import com.example.fisrtproject.data.repository.AppRepositoryImpl
import com.example.fisrtproject.domain.repository.AppRepository
import com.example.fisrtproject.domain.usecase.GetAppByIdUseCase
import com.example.fisrtproject.domain.usecase.GetAppUseCase
import com.example.fisrtproject.presentation.viewmodels.AppDetailViewModel
import com.example.fisrtproject.presentation.viewmodels.AppListViewModel

object Dependencies {

    private val repository: AppRepository = AppRepositoryImpl()

    private val getAllAppsUseCase = GetAppUseCase(repository)
    private val getAppByIdUseCase = GetAppByIdUseCase(repository)

    fun getAppListViewModel(): AppListViewModel {
        return AppListViewModel(getAllAppsUseCase)
    }

    fun getAppDetailViewModel(): AppDetailViewModel {
        return AppDetailViewModel(getAppByIdUseCase)
    }
}