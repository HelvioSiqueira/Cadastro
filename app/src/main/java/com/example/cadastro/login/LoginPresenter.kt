package com.example.cadastro.login

import com.example.cadastro.repository.CadastroRepository
import java.lang.Exception

class LoginPresenter(
    private var view: LoginView,
    private var repository: CadastroRepository
) {
    fun autenticar() {

        val login = view.autenticar()

        repository.cadastroByEmail(login.login) {
            if (it != null) {
                try {
                    if (login.validarSenha(it.senha)) {
                        view.aprovarAutenticacao()
                    } else {
                        view.invalidarAutenticacao()
                    }
                } catch (e: Exception) {
                    view.erroAutenticacao()
                }
            } else {
                view.emailInexistente()
            }
        }
    }

}