package com.example.cadastro.lista

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment
import com.example.cadastro.model.Cadastro
import com.example.cadastro.repository.MemoryRepository

class CadastroListFragment: ListFragment(), CadastroListView {

    val presenter = CadastroListPresenter(this, MemoryRepository)

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