package com.example.ocean_android_intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Acessar o elemento que está no layout XML
        // Classe R = recursos
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val etNome = findViewById<EditText>(R.id.etNome)
        val btnAbrirTela = findViewById<Button>(R.id.btnAbrirTela)

        // Alteramos o texto do tvResultado para uma string  que quisermos
        // tvResultado.text = "Paula Augusto"

        // Declaramos um ouvinte para eventos de clique no btnEnviar
        // Assim que um clique no btnEnviar ocorrer, o código dentro das chaves {} será executado
        btnEnviar.setOnClickListener {
            // pegamos o que foi digitado no EditText
            val nome = etNome.text
            // Caso o nome esteja em branco, entra no if
            if(nome.isBlank()) {
                // Exibe uma mensagem de erro no EditText
                etNome.error = getString(R.string.type_valid_name)
            } else {
                // Alteramos o texto do tvResultado para uma string que está armazenado na variável nome
                tvResultado.text = nome

                Toast.makeText(this, getString(R.string.updated_successfully), Toast.LENGTH_LONG).show()
            }
        }

        // Detectar clique no botão btnAbrirTela
        btnAbrirTela.setOnClickListener {
            //Criamos uma intenção de abrir a tela ResultadoActivity
            val abrirTelaIntent = Intent(this, ResultadoActivity::class.java)

            //Adicionamos uma informação à Intent que abre a nova tela
            val nome = "NOME_DIGITADO"
            val value = etNome.text

            abrirTelaIntent.putExtra(nome, value)

            // Registramos a intenção do Android
            startActivity(abrirTelaIntent)
        }
    }
}