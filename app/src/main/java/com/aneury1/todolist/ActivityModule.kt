package com.aneury1.todolist

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)
class ActivityModule  {

    @ActivityScoped
    @Provides
    @Named("GetString")
    fun provideGetApp(
        @ApplicationContext context: Context
    ) = context.getString(R.string.app_name)
}