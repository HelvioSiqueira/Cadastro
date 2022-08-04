package com.example.cadastro

interface CadastroRepository {
    fun save(cadastro: Cadastro)
    fun remove(vararg cadastro: Cadastro)
    fun cadastroById(id: Long, callback: (Cadastro?) -> Unit)
    fun search(term: String, callback: (List<Cadastro>) -> Unit)
}