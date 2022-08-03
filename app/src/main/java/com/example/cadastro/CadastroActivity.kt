package com.example.cadastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        showCadastroFragment()
    }

    private fun showCadastroFragment(){
        val fragment = CadastroFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.inicio, fragment, CadastroFragment.TAG_CADASTRO)
            .commit()
    }
}