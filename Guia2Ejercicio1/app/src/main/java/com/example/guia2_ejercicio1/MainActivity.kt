package com.example.guia2_ejercicio1

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //Variable
    lateinit var btnSaludar: Button
    lateinit var btnLimpiar: Button
    lateinit var etNombre: EditText
    lateinit var tvSaludo: TextView
    lateinit var tvMensaje: TextView

    // 2. Metodo del ciclo de vida del activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 3. Establecer archivo Layout
        setContentView(R.layout.activity_main)
        
        // 4. Referencias a elementos de la UI
        btnSaludar = findViewById(R.id.btnSaludar)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        etNombre = findViewById(R.id.etNombre)
        tvSaludo = findViewById(R.id.tvSaludo)
        tvSaludo = findViewById(R.id.tvMensaje)

        tvSaludo.text = ""
        tvSaludo.text = ""

        // 5. Listeners de los botones


    }
    // Funcion auxiliar para mostrar mensajes emergente
    private fun mostrarToast(
        mensaje : String,
        duracion: Int = Toast.LENGTH_SHORT
    ){
        Toast.makeText(
            this,
            mensaje,
            duracion
        ).show()
    }
}