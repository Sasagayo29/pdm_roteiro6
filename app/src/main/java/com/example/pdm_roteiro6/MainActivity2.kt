package com.example.pdm_roteiro6

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private val TAG = "CicloDeVida"
    private val NOME_ALUNO = "pdm_roteiro6"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.d(TAG, "onCreate() executado - Activity: MainActivity2 - Nome: $NOME_ALUNO")

        val tvDados = findViewById<TextView>(R.id.tvDados)
        val nome = intent.getStringExtra("NOME") ?: "Não informado"
        val email = intent.getStringExtra("EMAIL") ?: "Não informado"

        tvDados.text = "Nome: $nome\nE-mail: $email"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() executado - Activity: MainActivity2 - Nome: $NOME_ALUNO")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() executado - Activity: MainActivity2 - Nome: $NOME_ALUNO")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() executado - Activity: MainActivity2 - Nome: $NOME_ALUNO")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() executado - Activity: MainActivity2 - Nome: $NOME_ALUNO")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() executado - Activity: MainActivity2 - Nome: $NOME_ALUNO")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() executado - Activity: MainActivity2 - Nome: $NOME_ALUNO")
    }
}