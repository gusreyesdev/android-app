package com.timetonic.auth.login.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LoginEntity")
data class LoginEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val appkey : String
)