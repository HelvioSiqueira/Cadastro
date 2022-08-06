package com.example.cadastro.lista

import android.content.Context
import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.cadastro.R

class CadastroListActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        showCadastroListFragment()
    }

    private fun showCadastroListFragment(){

        val fragment = CadastroListFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.inicio, fragment, CadastroListFragment.TAG_CADASTRO_LIST)
            .commit()
    }

    companion object{
        fun open(context: Context){
            context.startActivity(Intent(context, CadastroListActivity::class.java))
        }
    }
}