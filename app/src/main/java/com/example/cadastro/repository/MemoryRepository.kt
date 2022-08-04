package com.example.cadastro.repository

import com.example.cadastro.model.Cadastro

object MemoryRepository: CadastroRepository {
    private var nextId = 1L
    private var cadastroList = mutableListOf<Cadastro>()

    override fun save(cadastro: Cadastro) {

        if (cadastro.id == 0L){
            cadastro.id = nextId++
            cadastroList.add(cadastro)
        }
    }

    override fun remove(vararg cadastro: Cadastro) {
        TODO("Not yet implemented")
    }

    override fun cadastroById(id: Long, callback: (Cadastro?) -> Unit) {
        callback(cadastroList.find { it.id == id })
    }

    override fun search(term: String, callback: (List<Cadastro>) -> Unit) {
        TODO("Not yet implemented")
    }
}