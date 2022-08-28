package com.example.cadastro.repository

import androidx.lifecycle.LiveData
import com.example.cadastro.model.Cadastro

interface CadastroRepository {
    fun save(cadastro: Cadastro)
    fun remove(cadastro: Cadastro)
    fun cadastroByEmail(email: String): LiveData<Cadastro>
    fun search(term: String): LiveData<List<Cadastro>>
}