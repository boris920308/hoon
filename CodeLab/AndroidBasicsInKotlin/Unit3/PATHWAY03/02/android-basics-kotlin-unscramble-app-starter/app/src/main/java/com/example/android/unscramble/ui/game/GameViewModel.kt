package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    /**
     * 경고: ViewModel에서 변경 가능한 데이터 입력란을 노출하지 마세요.
     * 다른 클래스에서 이 데이터를 수정할 수 없도록 해야 합니다.
     * ViewModel 내부의 변경 가능한 데이터는 항상 private여야 합니다.
     */

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while(String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }

        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++currentWordCount
            wordsList.add(currentWord)
        }
    }

//    fun nextWord() {
//        return if (currentWord < MAX_NO_OF_WORDS) {
//            getNextWord()
//            true
//        } else false
//    }

    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextWord()
    }

    private var score = 0
    private var currentWordCount = 0

    private lateinit var _currentScrambledWord: String
    val currentScrambledWord: String
        get() = _currentScrambledWord

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    override fun onCleared() {
        /**
         * 클래스에서 onCleared() 메서드를 재정의합니다.
         * ViewModel은 연결된 프래그먼트가 분리되거나 활동이 완료되면 소멸됩니다.
         * ViewModel이 소멸되기 직전에 onCleared() 콜백이 호출됩니다.
         */
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }
}