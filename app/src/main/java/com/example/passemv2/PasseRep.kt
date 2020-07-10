package com.example.passemv2

import androidx.lifecycle.LiveData
class WordRepository(private val PasseDao: WordDao) {


    val allWords: LiveData<List<Word>> = PasseDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        PasseDao.insert(word)
    }
}
