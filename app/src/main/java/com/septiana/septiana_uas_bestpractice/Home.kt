package com.septiana.septiana_uas_bestpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.septiana.septiana_uas_bestpractice.databinding.ActivityHomeBinding
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class Home : AppCompatActivity() , ProdukClickListener {
    var sliderView: SliderView? = null
    var images = intArrayOf(
        R.drawable.slider,
        R.drawable.slider,
        R.drawable.slider
    )
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sliderView = findViewById(R.id.image_slider)
        val sliderAdapter = SliderAdapter(images)
        sliderView?.setSliderAdapter(sliderAdapter)
        sliderView?.setIndicatorAnimation(IndicatorAnimationType.WORM)
        sliderView?.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        sliderView?.startAutoCycle()

        populateProduks()

        val homeActivity = this
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext,2)
            adapter = CardAdapter(produkList,homeActivity)
        }
    }

    override fun onClick(produk: Produk) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra(PRODUK_ID_EXTRA,produk.id)
        startActivity(intent)
    }

    private fun populateProduks() {
        val produk1 = Produk(
            R.drawable.makanan,
            title = "Makanan & Minuman",
            description = "Halaman Daftar Makanan dan Minuman"
        )
        produkList.add(produk1)

        val produk2 = Produk(
            R.drawable.rumah,
            title = "Rumah & Dapur",
            description = "Halaman Daftar Peralatan Rumah dan Dapur"
        )
        produkList.add(produk2)

        val produk3 = Produk(
            R.drawable.bayi,
            title = "Ibu & Anak",
            description = "Halaman Daftar Perlengkapan Ibu dan Anak"
        )
        produkList.add(produk3)


        val produk4 = Produk(
            R.drawable.kesehatan,
            title = "Kesehatan & Kecantikan",
            description = "Halaman Daftar Peralatan Kesehatan dan Kecantikan"
        )

        produkList.add(produk4)


    }


}