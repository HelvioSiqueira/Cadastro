package com.example.cadastro

import java.lang.Exception

class CadastrarPresenter(
    private var view: CadastarView,
    private var repository: CadastroRepository
) {

    private val validator = CadastroValidator()

    fun cadastrar(){

        val cadastro = view.cadastrarPessoa()

        if(validator.validade(cadastro)){
            try {
                repository.save(cadastro)
                view.testToast(cadastro)
            } catch (e: Exception){
                view.errorSaveCadastro()
            }
        } else {
            view.errorInvalidCadastro()
        }
    }
}