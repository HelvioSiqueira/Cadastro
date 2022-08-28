package com.example.cadastro.repository.room

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room
import com.example.cadastro.model.Cadastro
import com.example.cadastro.sqlite.DATABASE_NAME
import com.example.cadastro.sqlite.DATABASE_VERSION

@Database(entities = [Cadastro::class], version = DATABASE_VERSION)
abstract class CadastroDatabase: RoomDatabase() {

    abstract fun cadastroDao(): CadastroDao

    companion object{
        private var instance: CadastroDatabase? = null

        fun getDatabase(context: Context): CadastroDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    CadastroDatabase::class.java,
                    DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build()
            }

            return instance as CadastroDatabase
        }

        fun destroyInstance(){
            instance = null
        }
    }
}