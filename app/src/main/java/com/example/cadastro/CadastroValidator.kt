package com.example.cadastro

class CadastroValidator {
    fun validade(info: Cadastro) = with(info){
        checkName(nome) && checkEmail(email) && checkSenha(senha)
    }

    private fun checkName(name: String) = name.length in 1..100

    private fun checkEmail(email: String): Boolean{

        var valido = false

        if(email.length in 5..30){
            if (email.contains("@")){
                valido = true
            }
        }
        return valido
    }

    private fun checkSenha(senha: String): Boolean{

        var valido = false

        if(senha.length in 8..50){
            if (senha.contains("1")){
                valido = true
            }
        }
        return valido
    }
}