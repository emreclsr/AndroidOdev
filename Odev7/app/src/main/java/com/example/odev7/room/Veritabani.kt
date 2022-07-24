package com.example.odev7.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.odev7.data.entity.Isler

@Database(entities = [Isler::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getIslerDao() : IslerDao
}