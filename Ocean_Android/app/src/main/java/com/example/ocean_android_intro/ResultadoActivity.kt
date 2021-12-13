package com.example.ocean_android_intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val name = "NOME_DIGITADO"
        val value = intent.getCharSequenceExtra(name)

        //Acessa o elemento tvNome
        val tvNome = findViewById<TextView>(R.id.tvNome)

        // Altera o texto desse elemento
        tvNome.text = value

        //Implementação do botão voltar
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            finish()
        }
    }
}