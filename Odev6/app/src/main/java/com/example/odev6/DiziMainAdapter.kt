package com.example.odev6

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.odev6.databinding.FragmentAnasayfaBinding
import com.example.odev6.databinding.MainCardTasarimBinding

class DiziMainAdapter(var mContext:Context, var dizilerListesi:List<Diziler>)
    : RecyclerView.Adapter<DiziMainAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim:MainCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim: MainCardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = MainCardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val dizi = dizilerListesi.get(position)
        val t = holder.tasarim

        t.imageViewMainDizi.setImageResource(
            mContext.resources.getIdentifier(dizi.resimAdi, "drawable", mContext.packageName))

    }

    override fun getItemCount(): Int {
        return dizilerListesi.size
    }
}