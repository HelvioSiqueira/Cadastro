package com.example.cadastro.lista

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment
import androidx.lifecycle.Observer
import com.example.cadastro.model.Cadastro
import org.koin.androidx.viewmodel.ext.android.viewModel

class CadastroListFragment: ListFragment() {

    private val viewModel: CadastroListViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getListaCadastros().observe(viewLifecycleOwner, Observer { listaCadastros->

            Log.d("HSV", "Lista de cadastros: ${listaCadastros.joinToString(separator = ",")}")

            if(listaCadastros != null){
                showCadastros(listaCadastros)
            }
        })

        if(viewModel.getListaCadastros().value == null){
            search()
        }
    }

     fun showCadastros(cadastros: List<Cadastro>) {
        val adapter = ArrayAdapter<Cadastro>(requireContext(), android.R.layout.simple_list_item_1, cadastros)

        listAdapter = adapter
    }

    fun search(text: String = ""){
        viewModel.search(text)
    }

    companion object{
        const val TAG_CADASTRO_LIST = "tagCadastroList"

        fun newInstance() = CadastroListFragment()
    }
}