package com.example.odev7.room

import androidx.room.*
import com.example.odev7.data.entity.Isler

@Dao
interface IslerDao {
    @Query("SELECT * FROM isler")
    suspend fun tumIsler() : List<Isler>

    @Insert
    suspend fun isEkle(yeniIs:Isler)

    @Update
    suspend fun isGuncelle(guncellenenIs:Isler)

    @Delete
    suspend fun isSil(silinenIs:Isler)

    @Query("SELECT * FROM isler WHERE is_ad LIKE '%' || :aramaKelimesi || '%'")
    suspend fun isAra(aramaKelimesi:String) : List<Isler>
}