package com.example.cadastro.cadastrar

import com.example.cadastro.model.Cadastro

interface CadastrarView {
    fun cadastrarPessoa() : Cadastro
    fun errorInvalidCadastro()
    fun errorSaveCadastro()
    fun testToast(cadastro: Cadastro) //Retirar depois
    fun showLoginActivity()
    fun checaExiste()
    fun errorExiste()
}