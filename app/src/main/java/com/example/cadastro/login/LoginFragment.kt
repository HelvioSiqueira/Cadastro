package com.example.cadastro.login

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cadastro.lista.CadastroListActivity
import com.example.cadastro.R
import com.example.cadastro.repository.MemoryRepository
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment: Fragment(), LoginView {

    private val presenter = LoginPresenter(this, MemoryRepository)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login.setOnClickListener {
            presenter.autenticar()
        }
    }

    override fun autenticar(): Login {

        val login = Login()

        login.login = edtEmail.text.toString()
        login.senha = edtSenha.text.toString()

        return login
    }

    override fun aprovarAutenticacao() {
        Toast.makeText(requireContext(), "Logado com sucesso", Toast.LENGTH_LONG).show()

        CadastroListActivity.open(requireContext())
    }

    override fun emailInexistente() {
        Toast.makeText(requireContext(), "Email Inexistente", Toast.LENGTH_LONG).show()
    }

    override fun invalidarAutenticacao() {
        Toast.makeText(requireContext(), "Senha errada", Toast.LENGTH_LONG).show()
    }

    override fun erroAutenticacao() {
        Toast.makeText(requireContext(), "Não foi possivel logar", Toast.LENGTH_LONG).show()
    }

    companion object{
        const val TAG_LOGIN = "tagLogin"

        fun newInstance() = LoginFragment()
    }
}