package com.example.cadastro.repository

import com.example.cadastro.model.Cadastro

object MemoryRepository: CadastroRepository {
    private var nextId = 1L
    private var cadastroList = mutableListOf<Cadastro>()

    init {
        save(Cadastro(0, "Helvio", "helvio@gmail.com", "1234567890"))
        save(Cadastro(0, "Ana", "ana@gmail.com", "0987654321"))
    }

    override fun save(cadastro: Cadastro) {

        if (cadastro.id == 0L){
            cadastro.id = nextId++
            cadastroList.add(cadastro)
        }
    }

    override fun remove(vararg cadastro: Cadastro) {
        TODO("Not yet implemented")
    }

    override fun cadastroByEmail(email: String, callback: (Cadastro?) -> Unit) {
        callback(cadastroList.find { it.email == email })
    }

    override fun search(term: String, callback: (List<Cadastro>) -> Unit) {
        callback(
            if(term.isEmpty()) cadastroList
            else cadastroList.filter {
                it.email.uppercase().contains(term.uppercase())
            }
        )
    }
}