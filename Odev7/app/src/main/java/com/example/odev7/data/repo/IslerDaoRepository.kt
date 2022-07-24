package com.example.odev7.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.odev7.data.entity.Isler
import com.example.odev7.room.IslerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IslerDaoRepository(var isdao:IslerDao) {
    var islerListesi:MutableLiveData<List<Isler>>

    init {
        islerListesi = MutableLiveData()
    }

    fun isleriGetir() : MutableLiveData<List<Isler>>{
        return islerListesi
    }


    fun isKayit(is_ad:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniIs = Isler(0,is_ad)
            isdao.isEkle(yeniIs)
        }
    }

    fun isGuncelle(is_id:Int, is_ad:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenIs = Isler(is_id,is_ad)
            isdao.isGuncelle(guncellenenIs)
        }
    }

    fun isAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = isdao.isAra(aramaKelimesi)
        }
    }

    fun isSil(is_id:Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenIs = Isler(is_id,"")
            isdao.isSil(silinenIs)
            tumIsleriAl()
        }
    }

    fun tumIsleriAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = isdao.tumIsler()
        }
    }
}