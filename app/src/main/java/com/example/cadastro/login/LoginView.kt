package com.example.cadastro.login

interface LoginView {
    fun autenticar() : Login
    fun aprovarAutenticacao()
    fun emailInexistente()
    fun invalidarAutenticacao()
    fun erroAutenticacao()
}