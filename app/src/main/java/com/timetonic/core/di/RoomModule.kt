package com.timetonic.core.di

import android.content.Context
import androidx.room.Room
import com.timetonic.auth.login.data.database.dao.LoginDao
import com.timetonic.auth.login.data.database.LoginDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): LoginDatabase{
        return Room.databaseBuilder(appContext,LoginDatabase::class.java, "LoginDatabase" ).build()
    }

    @Singleton
    @Provides
    fun provideLoginDao(database: LoginDatabase): LoginDao {
        return database.loginDao()
    }

}