/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.di

import com.samad_talukder.mvvmcompose.domain.repository.GithubUserDetailRepository
import com.samad_talukder.mvvmcompose.domain.repository.GithubUserDetailRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideGithubUserDetailRepository(impl: GithubUserDetailRepositoryImpl): GithubUserDetailRepository
}