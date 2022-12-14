package com.example.cadastro.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cadastro.R
import com.example.cadastro.cadastrar.CadastrarFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        showLoginFragment()
    }

    private fun showLoginFragment(){
        val fragment = LoginFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.inicio, fragment, LoginFragment.TAG_LOGIN)
            .commit()
    }


    companion object{
        fun open(context: Context){
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }
}