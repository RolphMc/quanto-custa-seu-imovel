package com.avaliadorimovel.result

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.avaliadorimovel.R
import com.avaliadorimovel.result.interfaces.InterfaceResultView
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity(), InterfaceResultView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var extras: Bundle? = getIntent().getExtras()

        if (extras != null) {
            resultado_valor.setText(extras.getString("result"))
        }
    }

    override fun showResult() {

    }

    override fun navigateToMain() {
        TODO("Not yet implemented")
    }

    override fun navigateToHelp() {
        TODO("Not yet implemented")
    }
}