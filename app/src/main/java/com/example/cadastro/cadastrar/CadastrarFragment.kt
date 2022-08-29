package com.example.cadastro.cadastrar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cadastro.*
import com.example.cadastro.login.LoginActivity
import com.example.cadastro.model.Cadastro
import kotlinx.android.synthetic.main.fragment_cadastrar.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CadastrarFragment : Fragment() {

    private val viewModel: CadastrarViewModel by viewModel()

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
            cadastrarPessoa()
        }
    }

    private fun cadastrarPessoa() {
        val cadastro = Cadastro()

        cadastro.id = 0
        cadastro.nome = edtNome.text.toString()
        cadastro.email = edtEmail.text.toString()
        cadastro.senha = edtSenha.text.toString()

            if (viewModel.cadastrar(cadastro)) {
                showLoginActivity()
                testToast(cadastro)
            } else {
                errorInvalidCadastro()
            }
    }

    override fun onStop() {
        super.onStop()

        edtNome.text?.clear()
        edtEmail.text?.clear()
        edtSenha.text?.clear()

        edtNome.requestFocus()
    }

    fun errorInvalidCadastro() {
        Toast.makeText(requireContext(), R.string.error_invalid_cadastro, Toast.LENGTH_LONG).show()
    }

    fun errorSaveCadastro() {
        Toast.makeText(requireContext(), R.string.error_save_cadastro, Toast.LENGTH_LONG).show()
    }

    fun testToast(cadastro: Cadastro) {
        Toast.makeText(
            requireContext(),
            "${cadastro.nome}| ${cadastro.email} | ${cadastro.senha}",
            Toast.LENGTH_LONG
        ).show()
    }

    fun showLoginActivity() {
        LoginActivity.open(requireContext())
    }

    fun checaExiste() {
        TODO("Not yet implemented")
    }

    fun errorExiste() {
        TODO("Not yet implemented")
    }

    companion object {
        const val TAG_CADASTRO = "tagCadastro"

        fun newInstance() = CadastrarFragment()
    }
}