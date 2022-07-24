package com.example.odev7.di


import android.content.Context
import androidx.room.Room
import com.example.odev7.data.repo.IslerDaoRepository
import com.example.odev7.room.IslerDao
import com.example.odev7.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideIslerDaoRepository(isdao:IslerDao) : IslerDaoRepository{
        return IslerDaoRepository(isdao)
    }
    @Provides
    @Singleton
    fun provideIslerDao(@ApplicationContext context: Context) : IslerDao{
        val vt = Room.databaseBuilder(context,Veritabani::class.java, "odev7.sqlite")
            .createFromAsset("odev7.sqlite").build()
        return vt.getIslerDao()
    }

}