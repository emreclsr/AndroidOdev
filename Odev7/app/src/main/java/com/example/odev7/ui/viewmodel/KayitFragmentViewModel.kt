package com.example.odev7.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.odev7.data.repo.IslerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KayitFragmentViewModel @Inject constructor (var isrepo:IslerDaoRepository) : ViewModel() {

    fun kayit(is_ad:String){
        isrepo.isKayit(is_ad)
    }
}