package com.example.avaliadorimovel.result

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.avaliadorimovel.R

class ResultActivity : AppCompatActivity(), ResultView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
    }

    override fun showResult() {
        TODO("Not yet implemented")
    }

    override fun navigateToMain() {
        TODO("Not yet implemented")
    }

    override fun navigateToHelp() {
        TODO("Not yet implemented")
    }
}