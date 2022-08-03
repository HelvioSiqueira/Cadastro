package com.example.cadastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        if(savedInstanceState == null){
            showInicioFragment()
        }
    }

    private fun showInicioFragment(){
        val fragment = InicioFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.inicio, fragment, InicioFragment.TAG_INICIO)
            .commit()
    }
}