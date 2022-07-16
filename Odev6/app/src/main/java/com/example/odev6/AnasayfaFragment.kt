package com.example.odev6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.odev6.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {
    private lateinit var tasarim:FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Hide navigation bar
        activity!!.window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)



        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)

        tasarim.rvMain.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        tasarim.rvYeni.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        tasarim.rvOneri.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        val anaDiziListesi = ArrayList<Diziler>()
        val oneriDiziListesi = ArrayList<Diziler>()
        val yeniDiziListesi = ArrayList<Diziler>()

        val md1 = Diziler(1, "Kaçış", "kacis")
        val md2 = Diziler(2, "Atlanta", "atlanta")
        val md3 = Diziler(3, "Assembled", "assembled")
        val md4 = Diziler(4, "Thor Ragnarok", "thor")
        val md5 = Diziler(5, "She Hulk", "she_hulk")


        anaDiziListesi.add(md1)
        anaDiziListesi.add(md2)
        anaDiziListesi.add(md3)
        anaDiziListesi.add(md4)
        anaDiziListesi.add(md5)

        val adapterMain = DiziMainAdapter(requireContext(), anaDiziListesi)
        tasarim.rvMain.adapter = adapterMain



        val rd1 = Diziler(6, "Loki", "loki")
        val rd2 = Diziler(7,"Mandalorian", "mandalorian")
        val rd3 = Diziler(8, "Moon Knight", "moonknight")
        val rd4 = Diziler(9, "Ms. Marvel", "ms_marvel")
        val rd5 = Diziler(10, "Obi-Wan Kenobi", "obi_wan_kenobi")
        val rd6 = Diziler(11, "The Simpsons", "simpsons")

        oneriDiziListesi.add(rd1)
        oneriDiziListesi.add(rd2)
        oneriDiziListesi.add(rd3)
        oneriDiziListesi.add(rd4)
        oneriDiziListesi.add(rd5)
        oneriDiziListesi.add(rd6)

        val adapterOneri = DiziSecondaryAdapter(requireContext(), oneriDiziListesi)
        tasarim.rvOneri.adapter = adapterOneri

        val nd1 = Diziler(11, "Bir Bob's Burgers Filmi", "bobs_burger")
        val nd2 = Diziler(12, "İlk Dalga", "ilk_dalga")
        val nd3 = Diziler(13,"Mickey'nin Muhteşem Yazı", "mickey_muhtesem_yazi")
        val nd4 = Diziler(14, "Fx Pistol", "pistol")
        val nd5 = Diziler(15, "Prenses Remiksi", "prenses_remiksi")
        val nd6 = Diziler(16, "Assembled", "assemblednew")

        yeniDiziListesi.add(nd1)
        yeniDiziListesi.add(nd2)
        yeniDiziListesi.add(nd3)
        yeniDiziListesi.add(nd4)
        yeniDiziListesi.add(nd5)
        yeniDiziListesi.add(nd6)

        val adapterYeni = DiziSecondaryAdapter(requireContext(), yeniDiziListesi)
        tasarim.rvYeni.adapter = adapterYeni




        return tasarim.root
    }
}