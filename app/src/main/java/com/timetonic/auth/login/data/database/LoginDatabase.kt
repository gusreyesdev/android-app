package com.timetonic.auth.login.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.timetonic.auth.login.data.database.dao.LoginDao
import com.timetonic.auth.login.data.database.entities.LoginEntity

@Database(entities = [LoginEntity::class], version = 1)
abstract class LoginDatabase:RoomDatabase() {
    abstract fun loginDao(): LoginDao
}