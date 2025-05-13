/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.di

import com.samad_talukder.mvvmcompose.data.datasource.GithubUserDataSource
import com.samad_talukder.mvvmcompose.data.datasource.GithubUserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    fun bindGithubUserDetailDataSource(impl: GithubUserDataSourceImpl): GithubUserDataSource
}