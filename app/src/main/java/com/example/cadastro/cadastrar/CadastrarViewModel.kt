package com.example.cadastro.cadastrar

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cadastro.model.Cadastro
import com.example.cadastro.repository.CadastroRepository

class CadastrarViewModel(private val repository: CadastroRepository) : ViewModel() {

    private val validator = CadastroValidator()

    fun cadastrar(cadastro: Cadastro): Boolean {
        return validator.validate(cadastro).also { validated ->
            if (validated) repository.save(cadastro)
        }
    }
}