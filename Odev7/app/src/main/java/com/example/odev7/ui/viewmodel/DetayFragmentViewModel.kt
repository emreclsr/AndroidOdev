package com.example.odev7.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.odev7.data.repo.IslerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetayFragmentViewModel @Inject constructor (var isrepo:IslerDaoRepository): ViewModel() {

    fun guncelle(is_id:Int, is_ad:String){
        isrepo.isGuncelle(is_id, is_ad)
    }
}