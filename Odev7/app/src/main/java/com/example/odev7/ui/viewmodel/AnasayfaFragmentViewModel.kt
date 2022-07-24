package com.example.odev7.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.odev7.data.entity.Isler
import com.example.odev7.data.repo.IslerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnasayfaFragmentViewModel @Inject constructor (var isrepo:IslerDaoRepository) : ViewModel() {

    var islerListesi = MutableLiveData<List<Isler>>()

    init {
        isleriYukle()
        islerListesi = isrepo.isleriGetir()
    }

    fun ara(aramaKelimesi:String){
        isrepo.isAra(aramaKelimesi)
    }

    fun sil(is_id:Int){
        isrepo.isSil(is_id)
    }

    fun isleriYukle() {
        isrepo.tumIsleriAl()
    }
}