package com.example.cadastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CadastrarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        showCadastroFragment()
    }

    private fun showCadastroFragment(){
        val fragment = CadastrarFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.inicio, fragment, CadastrarFragment.TAG_CADASTRO)
            .commit()
    }
}