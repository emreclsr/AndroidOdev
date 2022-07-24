package com.example.odev7.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odev7.R
import com.example.odev7.data.entity.Isler
import com.example.odev7.databinding.CardTasarimBinding
import com.example.odev7.databinding.FragmentAnasayfaBinding
import com.example.odev7.ui.fragment.AnasayfaFragmentDirections
import com.example.odev7.ui.viewmodel.AnasayfaFragmentViewModel
import com.example.odev7.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class IslerAdapter(var mContext:Context, var islerListesi:List<Isler>, var viewModel:AnasayfaFragmentViewModel)
    : RecyclerView.Adapter<IslerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)

        val tasarim:CardTasarimBinding = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacakIs = islerListesi.get(position)
        val t = holder.tasarim
        t.yapilacakIsNesnesi = yapilacakIs

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.anasayfaDetayGecis(yapilacakIs = yapilacakIs)
            Navigation.gecisYap(it, gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it, "${yapilacakIs.is_ad} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(yapilacakIs.is_id)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return islerListesi.size
    }
}