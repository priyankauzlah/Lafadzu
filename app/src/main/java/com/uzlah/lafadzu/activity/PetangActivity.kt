package com.uzlah.lafadzu.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.uzlah.lafadzu.R
import com.uzlah.lafadzu.adapter.DzikirDoaAdapter
import com.uzlah.lafadzu.databinding.ActivityPetangBinding
import com.uzlah.lafadzu.model.DataDzikirDoa
import com.uzlah.lafadzu.model.DzikirDoa

class PetangActivity : AppCompatActivity() {
    private lateinit var petangBinding : ActivityPetangBinding
    private var listDzikirDoa : ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        petangBinding = ActivityPetangBinding.inflate(layoutInflater)
        setContentView(petangBinding.root)
        supportActionBar?.hide()
        showRecyclerList()
        back()
    }

    private fun back() {
        petangBinding.ivBackPetang.setOnClickListener{
            startActivity(DzikirPagiPetangActivity.getLaunchService(this))
        }
    }
    private fun showRecyclerList() {
        listDzikirDoa.clear()
        listDzikirDoa.addAll(DataDzikirDoa.listDzikirPetang)
        petangBinding.rvDzikirPetang.setHasFixedSize(true)
        petangBinding.rvDzikirPetang.layoutManager = LinearLayoutManager(this)
        petangBinding.rvDzikirPetang.adapter = DzikirDoaAdapter(listDzikirDoa)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        fun getLaunchService(from: Context) = Intent(from, PetangActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
}