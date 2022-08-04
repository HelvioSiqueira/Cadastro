package com.example.cadastro

interface CadastrarView {
    fun cadastrarPessoa() : Cadastro
    fun errorInvalidCadastro()
    fun errorSaveCadastro()
    fun testToast(cadastro: Cadastro)
    fun showLogin()
}