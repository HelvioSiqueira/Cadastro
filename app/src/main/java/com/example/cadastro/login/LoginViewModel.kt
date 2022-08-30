package com.example.cadastro.login

import android.util.Log
import androidx.lifecycle.*
import com.example.cadastro.repository.CadastroRepository
import com.example.cadastro.model.Cadastro

class LoginViewModel(private val repository: CadastroRepository) : ViewModel() {

    private val emailExiste = MutableLiveData<Boolean>().apply { value = true }

    private var autenticou = false

    fun autenticar(login: Login): Boolean {

        Log.d("HSV", login.login)

        val emailEncontrado = repository.cadastroByEmail(login.login)

        if (emailEncontrado != null) {
            if (login.validarSenha(emailEncontrado.senha)) {
                autenticou = true
            }
        } else {
            emailExiste.value = false
        }

        return autenticou
    }

    fun getEmailExite(): LiveData<Boolean> = emailExiste
}