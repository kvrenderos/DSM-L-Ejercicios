package com.example.guia2_ejercicio1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    // Variables
    private lateinit var btnSaludar: Button
    private lateinit var btnLimpiar: Button
    private lateinit var etNombre: EditText
    private lateinit var etApellido: EditText
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
        etApellido = findViewById(R.id.etApellido)
        tvSaludo = findViewById(R.id.tvSaludo)
        tvMensaje = findViewById(R.id.tvMensaje)

        // Limpiar TextView al iniciar
        tvSaludo.text = ""
        tvMensaje.text = ""

        // Botón Saludar
        btnSaludar.setOnClickListener {

            val nombre = etNombre.text.toString().trim()
            val apellido = etApellido.text.toString().trim()

            if (nombre.isEmpty() || apellido.isEmpty()) {
                mostrarToast("Debe ingresar el nombre y el apellido.")
            } else {

                val hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

                val saludo = if (hora in 6..17) {
                    "Hola, buenos días $nombre $apellido"
                } else {
                    "Hola, buenas noches $nombre $apellido"
                }

                tvSaludo.text = saludo
                tvMensaje.text = "Bienvenido al laboratorio 2 de DSM441."

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