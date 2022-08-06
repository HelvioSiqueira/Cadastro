package com.example.cadastro.model

data class Cadastro(
    var id: Long = 0,
    var nome: String = "",
    var email: String = "",
    var senha: String = ""
){
    override fun toString(): String = nome
}
