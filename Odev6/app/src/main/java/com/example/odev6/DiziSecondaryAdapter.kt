package com.example.odev6

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.odev6.databinding.SecondaryCardTasarimBinding

class DiziSecondaryAdapter(var mContext: Context, var dizilerListesi:List<Diziler>)
    : RecyclerView.Adapter<DiziSecondaryAdapter.CardTasatimTutucu>() {

    inner class CardTasatimTutucu(tasarim:SecondaryCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: SecondaryCardTasarimBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasatimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = SecondaryCardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasatimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasatimTutucu, position: Int) {
        val dizi = dizilerListesi.get(position)
        val t = holder.tasarim

        t.imageViewSecondaryDizi.setImageResource(
            mContext.resources.getIdentifier(dizi.resimAdi, "drawable", mContext.packageName))

    }

    override fun getItemCount(): Int {
        return dizilerListesi.size
    }
}
