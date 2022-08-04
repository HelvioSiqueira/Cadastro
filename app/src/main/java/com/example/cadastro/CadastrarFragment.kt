package com.example.cadastro

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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

    override fun showLogin() {
        LoginActivity.open(requireContext())
    }

    companion object{
        const val TAG_CADASTRO = "tagCadastro"

        fun newInstance() = CadastrarFragment()
    }
}