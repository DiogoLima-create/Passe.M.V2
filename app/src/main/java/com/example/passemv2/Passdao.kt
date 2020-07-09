package com.example.passemv2

import androidx.lifecycle.LiveData
import androidx.room.Dao //classe DAO para Room
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {

    @Query("SELECT * from word_passe ORDER BY passe ASC")
    fun getAlphabetizedWords():LiveData <List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word) //declara uma funçao de suspensao pra inserir uma passe

    @Query("DELETE FROM word_passe")
    suspend fun deleteAll()
}