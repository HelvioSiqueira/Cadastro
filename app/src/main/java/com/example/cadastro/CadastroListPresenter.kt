package com.example.cadastro

import com.example.cadastro.repository.CadastroRepository

class CadastroListPresenter(
    private val view: CadastroListView,
    private val repository: CadastroRepository) {

    fun searchCadastros(term: String){
        repository.search(term){
            view.showCadastros(it)
        }
    }
}