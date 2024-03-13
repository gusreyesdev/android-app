package com.timetonic.auth.login.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.timetonic.auth.login.data.database.entities.LoginEntity

@Dao
interface LoginDao {

    @Query("SELECT * FROM LoginEntity")
    suspend fun getLoginData(): List<LoginEntity>

    @Insert
    suspend fun addLoginData(loginEntity: LoginEntity): Long
}