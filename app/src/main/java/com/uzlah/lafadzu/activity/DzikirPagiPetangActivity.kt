package com.uzlah.lafadzu.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.uzlah.lafadzu.MainActivity
import com.uzlah.lafadzu.R
import com.uzlah.lafadzu.databinding.ActivityDzikirPagiPetangBinding
import com.uzlah.lafadzu.model.DzikirDoa

class DzikirPagiPetangActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var pagiPetangBinding: ActivityDzikirPagiPetangBinding
    private var listDzikirDoa: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pagiPetangBinding = ActivityDzikirPagiPetangBinding.inflate(layoutInflater)
        setContentView(pagiPetangBinding.root)
        supportActionBar?.hide()
        back()

        pagiPetangBinding.cvDzikirPagi.setOnClickListener(this)
        pagiPetangBinding.cvDzikirPetang.setOnClickListener(this)
        pagiPetangBinding.btnDzikirPagi.setOnClickListener(this)
        pagiPetangBinding.btnDzikirPetang.setOnClickListener(this)

    }

    private fun back() {
        pagiPetangBinding.ivBackDzikirPagiPetang.setOnClickListener {
            startActivity(MainActivity.getLaunchService(this))
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.cvDzikirPagi -> startActivity(PagiActivity.getLaunchService(this))
            R.id.cvDzikirPetang -> startActivity(PetangActivity.getLaunchService(this))
            R.id.btnDzikirPagi -> startActivity(PagiActivity.getLaunchService(this))
            R.id.btnDzikirPetang -> startActivity(PetangActivity.getLaunchService(this))
        }
    }

    companion object {
        fun getLaunchService(from: Context) =
            Intent(from, DzikirPagiPetangActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}