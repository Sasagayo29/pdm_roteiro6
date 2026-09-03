package com.example.pdm_roteiro6

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {

    private val TAG = "CicloDeVida"
    private val NOME_ALUNO = "pdm_roteiro6"
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var etNome: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnEnviar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate() executado - Activity: MainActivity1 - Nome: $NOME_ALUNO")

        etNome = findViewById(R.id.etNome)
        etEmail = findViewById(R.id.etEmail)
        btnEnviar = findViewById(R.id.btnEnviar)
        sharedPreferences = getSharedPreferences("Roteiro6Prefs", Context.MODE_PRIVATE)

        btnEnviar.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("NOME", etNome.text.toString())
                putExtra("EMAIL", etEmail.text.toString())
            }
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() executado - Activity: MainActivity1 - Nome: $NOME_ALUNO")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() executado - Activity: MainActivity1 - Nome: $NOME_ALUNO")

        // Recuperando dados salvos no SharedPreferences
        val nomeSalvo = sharedPreferences.getString("NOME_SALVO", "")
        val emailSalvo = sharedPreferences.getString("EMAIL_SALVO", "")

        if (!nomeSalvo.isNullOrEmpty() || !emailSalvo.isNullOrEmpty()) {
            etNome.setText(nomeSalvo)
            etEmail.setText(emailSalvo)
            Log.d(TAG, "Dados RECUPERADOS com sucesso no onResume - MainActivity1")
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() executado - Activity: MainActivity1 - Nome: $NOME_ALUNO")

        val editor = sharedPreferences.edit()
        editor.putString("NOME_SALVO", etNome.text.toString())
        editor.putString("EMAIL_SALVO", etEmail.text.toString())
        editor.apply()

        Log.d(TAG, "Dados SALVOS com sucesso no onPause - MainActivity1")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() executado - Activity: MainActivity1 - Nome: $NOME_ALUNO")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() executado - Activity: MainActivity1 - Nome: $NOME_ALUNO")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() executado - Activity: MainActivity1 - Nome: $NOME_ALUNO")
    }
}