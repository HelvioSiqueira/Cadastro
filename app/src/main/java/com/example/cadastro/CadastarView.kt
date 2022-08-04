package com.example.cadastro

interface CadastarView {
    fun cadastrarPessoa() : Cadastro
    fun errorInvalidCadastro()
    fun errorSaveCadastro()
    fun testToast(cadastro: Cadastro)
}