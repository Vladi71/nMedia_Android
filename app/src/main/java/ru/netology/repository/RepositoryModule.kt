package ru.netology.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindPostRepository( impl: PostRepositoryImpl): PostRepository

    @Binds
    @Singleton
    fun bindUserPostRepository( impl: UserRepositoryImpl): UserRepository
}