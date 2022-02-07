package ru.netology.auth

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.netology.nmedia.auth.AppAuth
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AuthModule {

    @Singleton
    @Provides
    fun provideAuthPrefs(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("auth", Context.MODE_PRIVATE)
}