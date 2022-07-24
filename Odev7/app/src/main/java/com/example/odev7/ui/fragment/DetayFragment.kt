package com.example.odev7.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.odev7.R
import com.example.odev7.databinding.FragmentDetayBinding
import com.example.odev7.ui.viewmodel.DetayFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var tasarim:FragmentDetayBinding
    private lateinit var viewModel: DetayFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_detay, container,false)
        tasarim.detayFragment = this
        tasarim.detayToolbarBaslik = "Yapılacak İş Detay"

        val bundle:DetayFragmentArgs by navArgs()
        val gelenIs = bundle.yapilacakIs
        tasarim.yapilacakIsNesnesi = gelenIs

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetayFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonGuncelle(is_id:Int, is_ad:String){
        viewModel.guncelle(is_id, is_ad)
        activity?.onBackPressed()
    }
}