package com.example.cadastro.login

data class Login(
    var login: String = "",
    var senha: String = ""){

    fun validarSenha(senhaDigitada: String): Boolean{
        return senhaDigitada == senha
    }
}
