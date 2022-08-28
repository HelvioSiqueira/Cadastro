package com.example.cadastro.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cadastro.repository.CadastroRepository

class LoginViewModel(private val repository: CadastroRepository) : ViewModel() {

    private val emailExiste = MutableLiveData<Boolean>().apply { value = true }

    private var autenticou = false

    fun autenticar(login: Login): Boolean {

        val loginEncontrado = repository.cadastroByEmail(login.login)

        if(loginEncontrado.value != null){
            if(login.validarSenha(login.senha)){
                autenticou = true
            }
        } else {
            emailExiste.value = false
        }

        return autenticou
    }

    fun getEmailExite(): LiveData<Boolean> = emailExiste
}