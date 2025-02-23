package com.example.edu.videotesttask.di

import com.example.edu.videotesttask.domain.Repository
import com.example.edu.videotesttask.domain.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    /**
     * Тут конечно тоже лучше бы сделать чтобы были usecase для разных экранов, но запрос у нас один
     * думаю тут можно и без этого обойтись
     */
    @Singleton
    @Binds
    abstract fun provideRepos(impl: RepositoryImpl):Repository


}