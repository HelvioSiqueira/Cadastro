package com.example.cadastro.login

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.cadastro.lista.CadastroListActivity
import com.example.cadastro.R
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModel()

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
            autenticar()
        }
    }

    fun autenticar() {

        val login = Login()

        login.login = edtEmail.text.toString()
        login.senha = edtSenha.text.toString()

        try {
            if (viewModel.autenticar(login)) {
                aprovarAutenticacao()
            } else {
                invalidarAutenticacao()
                emailInexistente()
            }
        } catch (e: Exception) {
            erroAutenticacao()
        }
    }

    fun aprovarAutenticacao() {
        Toast.makeText(requireContext(), "Logado com sucesso", Toast.LENGTH_LONG).show()

        CadastroListActivity.open(requireContext())
    }

    fun emailInexistente() {
        viewModel.getEmailExite().observe(viewLifecycleOwner, Observer { exite ->
            if (!exite) {
                Toast.makeText(requireContext(), "Email Inexistente", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun invalidarAutenticacao() {
        Toast.makeText(requireContext(), "Senha errada", Toast.LENGTH_LONG).show()
    }

    fun erroAutenticacao() {
        Toast.makeText(requireContext(), "Não foi possivel logar", Toast.LENGTH_LONG).show()
    }

    companion object {
        const val TAG_LOGIN = "tagLogin"

        fun newInstance() = LoginFragment()
    }
}