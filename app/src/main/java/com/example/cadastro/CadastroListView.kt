package com.example.cadastro

import com.example.cadastro.model.Cadastro

interface CadastroListView {

    fun showCadastros(cadastro: List<Cadastro>)
}