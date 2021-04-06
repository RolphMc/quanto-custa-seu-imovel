package com.avaliadorimovel.result

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.avaliadorimovel.R
import com.avaliadorimovel.result.interfaces.InterfaceResultView

class ResultActivity : AppCompatActivity(), InterfaceResultView {
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