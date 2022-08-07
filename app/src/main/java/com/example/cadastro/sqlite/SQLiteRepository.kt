package com.example.cadastro.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.cadastro.model.Cadastro
import com.example.cadastro.repository.CadastroRepository

class SQLiteRepository(ctx: Context): CadastroRepository {
    private val helper: CadastroSqlHelper = CadastroSqlHelper(ctx)

    private fun insert(cadastro: Cadastro){
        val db = helper.writableDatabase
        val cv = ContentValues().apply {
            put(COLUMN_NAME, cadastro.nome)
            put(COLUMN_EMAIL, cadastro.email)
            put(COLUMN_SENHA, cadastro.senha)
        }

        val id = db.insert(TABLE_CADASTRO, null, cv)

        if(id != -1L){
            cadastro.id = id
        }

        db.close()
    }

    private fun update(){
        TODO("Not yet implemented")
    }

    override fun save(cadastro: Cadastro) {
        insert(cadastro)
    }

    override fun remove(vararg cadastro: Cadastro) {
        TODO("Not yet implemented")
    }

    override fun search(term: String, callback: (List<Cadastro>) -> Unit) {
        var sql = "SELECT * FROM $TABLE_CADASTRO"
        var args: Array<String>? = null

        if(term.isEmpty()){
            sql += " WHERE $COLUMN_EMAIL LIKE ?"
            args = arrayOf("%$term%")
        }

        sql += " ORDER BY $COLUMN_NAME"

        val db = helper.readableDatabase
        val cursor = db.rawQuery(sql, args)

        val cadastros = ArrayList<Cadastro>()

        while (cursor.moveToNext()){
            val cadastro = cadastroFromCursor(cursor)
            cadastros.add(cadastro)
        }

        cursor.close()
        db.close()
        callback(cadastros)
    }

    override fun cadastroByEmail(email: String, callback: (Cadastro?) -> Unit) {
        val sql = "SELECT * FROM $TABLE_CADASTRO WHERE $COLUMN_EMAIL = ?"
        val db = helper.readableDatabase
        val cursor = db.rawQuery(sql, arrayOf(email))

        val cadastro = if(cursor.moveToNext()) cadastroFromCursor(cursor) else null

        callback(cadastro)
    }

    private fun cadastroFromCursor(cursor: Cursor): Cadastro{
        val id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID))
        val nome = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
        val email = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL))
        val senha = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SENHA))

        return Cadastro(id, nome, email, senha)
    }
}