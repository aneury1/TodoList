package com.aneury1.todolist

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import dagger.internal.SingleCheck
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Singleton
    @Provides
    fun provideThisString() = "This is a simple String"

    @Singleton
    @Provides
    fun provideDataSession(): DataSession {
       return DataSession
    }
}