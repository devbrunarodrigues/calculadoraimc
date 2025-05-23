package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val  KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra("KEY_RESULT_IMC", 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvclassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()


        val classificacao: String
        val corText: Int

        if (result <= 18.5f) {
            classificacao = "MAGREZA"
            corText = ContextCompat.getColor(this, R.color.vermelho)
        } else if (result > 18.5f && result <= 24.9f) {
            classificacao = "NORMAL"
            corText = ContextCompat.getColor(this, R.color.verde)
        } else if (result > 25f && result <= 29.9f) {
            classificacao = "SOBREPESO"
            corText = ContextCompat.getColor(this, R.color.amarelo)
        } else if (result > 30f && result <= 39.9f) {
            classificacao = "OBESIDADE"
            corText = ContextCompat.getColor(this, R.color.vermelho)
        } else if (result > 30f && result <= 39.9f){
            classificacao = "OBESIDADE"
            corText = ContextCompat.getColor(this, R.color.vermelho)
        } else {
           classificacao =  "OBESIDADE GRAVE"
            corText = ContextCompat.getColor(this, R.color.vermelho)
        }

        tvclassificacao.text = classificacao
        tvclassificacao.setTextColor(corText)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}