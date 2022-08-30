package com.example.cadastro.lista

import android.icu.text.StringSearch
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.cadastro.model.Cadastro
import com.example.cadastro.repository.CadastroRepository

class CadastroListViewModel(private val repository: CadastroRepository) : ViewModel() {

    private val searchTerm = MutableLiveData<String>()
    private val listaCadastros = Transformations.switchMap(searchTerm) { term ->
        repository.search("%$term%")
    }

    fun getSearchTerm(): LiveData<String>? = searchTerm

    fun search(term: String = ""){
        searchTerm.value = term
    }

    fun getListaCadastros(): LiveData<List<Cadastro>> = listaCadastros
}