package com.uzlah.lafadzu.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uzlah.lafadzu.MainActivity
import com.uzlah.lafadzu.R
import com.uzlah.lafadzu.databinding.ActivityDetailArtikelBinding
import com.uzlah.lafadzu.model.Artikel

class DetailArtikelActivity : AppCompatActivity() {
    private lateinit var detailArtikelBinding: ActivityDetailArtikelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailArtikelBinding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(detailArtikelBinding.root)
        supportActionBar?.hide()
        supportActionBar?.title = "Artikel Islami"
        back()

        val dataArtikel = intent.getParcelableExtra<Artikel>("data")
        detailArtikelBinding.ivDetail.setImageResource(dataArtikel!!.imageArtikel)
        detailArtikelBinding.tvTitleDetail.text = dataArtikel.titleArtikel
        detailArtikelBinding.tvDescDetail.text = dataArtikel.descArtikel
    }

    private fun back() {
        detailArtikelBinding.ivBackDetailArtikel.setOnClickListener {
            startActivity(MainActivity.getLaunchService(this))
        }

    }
}