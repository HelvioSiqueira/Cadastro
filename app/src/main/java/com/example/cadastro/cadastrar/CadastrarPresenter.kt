package com.example.cadastro.cadastrar

import com.example.cadastro.repository.CadastroRepository
import java.lang.Exception

class CadastrarPresenter(
    private var view: CadastrarView,
    private var repository: CadastroRepository
) {

    private val validator = CadastroValidator()

    fun cadastrar(){

        val cadastro = view.cadastrarPessoa()

        if(validator.validade(cadastro)){
            try {
                repository.save(cadastro)
                view.showLoginActivity()
                view.testToast(cadastro)
            } catch (e: Exception){
                view.errorSaveCadastro()
            }
        } else {
            view.errorInvalidCadastro()
        }
    }
}