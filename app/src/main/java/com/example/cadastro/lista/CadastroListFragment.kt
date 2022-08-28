package com.example.cadastro.lista

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment
import com.example.cadastro.model.Cadastro
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class CadastroListFragment: ListFragment(), CadastroListView {

    val presenter: CadastroListPresenter by inject { parametersOf(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.searchCadastros("")
    }

    override fun showCadastros(cadastro: List<Cadastro>) {
        val adapter = ArrayAdapter<Cadastro>(requireContext(), android.R.layout.simple_list_item_1, cadastro)

        listAdapter = adapter
    }

    companion object{
        const val TAG_CADASTRO_LIST = "tagCadastroList"

        fun newInstance() = CadastroListFragment()
    }
}