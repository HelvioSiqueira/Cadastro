package com.example.cadastro.lista

import com.example.cadastro.model.Cadastro

interface CadastroListView {

    fun showCadastros(cadastro: List<Cadastro>)
}