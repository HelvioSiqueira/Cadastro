package com.example.cadastro.cadastrar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cadastro.*
import com.example.cadastro.login.LoginActivity
import com.example.cadastro.model.Cadastro
import com.example.cadastro.repository.MemoryRepository
import kotlinx.android.synthetic.main.fragment_cadastrar.*

class CadastrarFragment: Fragment(), CadastrarView {

    private val presenter = CadastrarPresenter(this, MemoryRepository)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cadastrar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_cadastrar.setOnClickListener {
            presenter.cadastrar()
        }
    }

    override fun cadastrarPessoa(): Cadastro {
        val cadastro = Cadastro()

        cadastro.id = 0L
        cadastro.nome = edtNome.text.toString()
        cadastro.email = edtEmail.text.toString()
        cadastro.senha = edtSenha.text.toString()

        edtNome.text?.clear()
        edtEmail.text?.clear()
        edtSenha.text?.clear()

        edtNome.requestFocus()

        return cadastro
    }

    override fun errorInvalidCadastro() {
        Toast.makeText(requireContext(), R.string.error_invalid_cadastro, Toast.LENGTH_LONG).show()
    }

    override fun errorSaveCadastro() {
        Toast.makeText(requireContext(), R.string.error_save_cadastro, Toast.LENGTH_LONG).show()
    }

    override fun testToast(cadastro: Cadastro){
        Toast.makeText(requireContext(), "${cadastro.nome}| ${cadastro.email} | ${cadastro.senha}", Toast.LENGTH_LONG).show()
    }

    override fun showLoginActivity() {
        LoginActivity.open(requireContext())
    }

    override fun checaExiste() {
        TODO("Not yet implemented")
    }

    override fun errorExiste() {
        TODO("Not yet implemented")
    }

    companion object{
        const val TAG_CADASTRO = "tagCadastro"

        fun newInstance() = CadastrarFragment()
    }
}