package com.example.guia2_ejercicio1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Variables
    private lateinit var btnSaludar: Button
    private lateinit var btnLimpiar: Button
    private lateinit var etNombre: EditText
    private lateinit var tvSaludo: TextView
    private lateinit var tvMensaje: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Layout
        setContentView(R.layout.activity_main)

        // Referencias
        btnSaludar = findViewById(R.id.btnSaludar)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        etNombre = findViewById(R.id.etNombre)
        tvSaludo = findViewById(R.id.tvSaludo)
        tvMensaje = findViewById(R.id.tvMensaje)

        // Limpiar TextView al iniciar
        tvSaludo.text = ""
        tvMensaje.text = ""

        // Botón Saludar
        btnSaludar.setOnClickListener {

            val nombre = etNombre.text.toString().trim()

            if (nombre.isEmpty()) {
                mostrarToast("Error, el campo nombre está vacío.")
            } else {
                val saludo = "Hola, $nombre"
                val mensaje = "Bienvenido al laboratorio 2 de DSM441."

                tvSaludo.text = saludo
                tvMensaje.text = mensaje

                mostrarToast("Saludo generado exitosamente.")
            }
        }

        // Botón Limpiar
        btnLimpiar.setOnClickListener {

            etNombre.text.clear()

            tvSaludo.text = ""
            tvMensaje.text = ""

            etNombre.requestFocus()

            mostrarToast("Pantalla reiniciada.")
        }
    }

    // Función auxiliar
    private fun mostrarToast(
        mensaje: String,
        duracion: Int = Toast.LENGTH_SHORT
    ) {
        Toast.makeText(this, mensaje, duracion).show()
    }
}