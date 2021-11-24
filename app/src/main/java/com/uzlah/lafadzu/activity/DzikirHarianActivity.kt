package com.uzlah.lafadzu.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.uzlah.lafadzu.MainActivity
import com.uzlah.lafadzu.R
import com.uzlah.lafadzu.adapter.DzikirDoaAdapter
import com.uzlah.lafadzu.databinding.ActivityDzikirHarianBinding
import com.uzlah.lafadzu.model.DzikirDoa

class DzikirHarianActivity : AppCompatActivity() {
    private lateinit var dzikirHarianBinding: ActivityDzikirHarianBinding
    private var listDzikirHarian: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dzikirHarianBinding = ActivityDzikirHarianBinding.inflate(layoutInflater)
        setContentView(dzikirHarianBinding.root)

        supportActionBar?.hide()
        setContentView(dzikirHarianBinding.root)

        showRecyclerList()
        initData()
        back()
    }

    private fun initData() {
        val desc = resources.getStringArray(R.array.dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.terjemah_dzikir_doa_harian)
        listDzikirHarian.clear()
        for (data in desc.indices){
            listDzikirHarian.add(
                DzikirDoa(desc[data], lafaz[data], terjemah[data])
            )
        }

    }

    private fun showRecyclerList() {
        dzikirHarianBinding.rvDzikirHarian.layoutManager = LinearLayoutManager(this)
        dzikirHarianBinding.rvDzikirHarian.adapter = DzikirDoaAdapter(listDzikirHarian)
        dzikirHarianBinding.rvDzikirHarian.setHasFixedSize(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    companion object {
        fun getLaunchService(from: Context) =
            Intent(from, DzikirHarianActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
    }

    private fun back() {
        dzikirHarianBinding.ivBackDzikirHarian.setOnClickListener {
            startActivity(MainActivity.getLaunchService(this))
        }
    }
}