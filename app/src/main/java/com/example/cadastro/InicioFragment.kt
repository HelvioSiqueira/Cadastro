package com.example.cadastro

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_inicio.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.btn_login

class InicioFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login.setOnClickListener {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }

        btn_cadastrar.setOnClickListener {
            startActivity(Intent(requireContext(), CadastroActivity::class.java))
        }
    }

    companion object{

        const val TAG_INICIO = "tagInicio"

        fun newInstance() = InicioFragment()
    }
}