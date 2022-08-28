package com.example.cadastro.lista

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cadastro.model.Cadastro
import com.example.cadastro.repository.CadastroRepository

class CadastroListViewModel(private val repository: CadastroRepository): ViewModel() {

    private val listaCadastros = MutableLiveData<List<Cadastro>>()

    fun searchCadastros(term: String){
        repository.search(term){ list ->
            listaCadastros.value = list
        }
    }

    fun getListaCadastros(): LiveData<List<Cadastro>> = listaCadastros
}