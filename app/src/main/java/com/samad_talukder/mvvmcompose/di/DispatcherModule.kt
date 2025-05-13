package com.samad_talukder.mvvmcompose.di

import com.samad_talukder.mvvmcompose.utils.DefaultDispatcherProvider
import com.samad_talukder.mvvmcompose.utils.DispatchersProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {

    @Binds
    @Singleton
    abstract fun bindDispatcherProvider(defaultDispatcherProvider: DefaultDispatcherProvider): DispatchersProvider
}