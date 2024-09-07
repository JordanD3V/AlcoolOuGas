package com.example.alcoolgasolina

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editInputAlcool: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editInputGasolina: TextInputEditText

    private lateinit var buttonCalcular: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inicializarComponentesInterface()

        buttonCalcular.setOnClickListener {
            calcularMelhorPreço()
        }
    }

    private fun inicializarComponentesInterface() {
        textInputAlcool = findViewById(R.id.txt_input_alcool)
        textInputGasolina = findViewById(R.id.txt_input_gasolina)

        editInputAlcool = findViewById(R.id.edit_txt_alcool)
        editInputGasolina = findViewById(R.id.edit_txt_gasolina)

        buttonCalcular = findViewById(R.id.btn_calcular)
        txtResultado = findViewById(R.id.txt_resultado)
    }

    private fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {
        textInputAlcool.error = null
        textInputGasolina.error = null

        if (precoAlcool.isEmpty()) {
            textInputAlcool.error = "Digite o preço do álcool"
            return false
        } else if (precoGasolina.isEmpty()) {
            textInputGasolina.error = "Digite o preço da gasolina"
            return false
        }

        return true
    }

    private fun calcularMelhorPreço() {

        val precoAlcool = editInputAlcool.toString()
        val precoGasolina = editInputGasolina.toString()


        val precoAlcoolNumber = precoAlcool.toDouble()
        val precoGasolinaNumber = precoGasolina.toDouble()
        val resultado = (precoAlcoolNumber / precoGasolinaNumber)

        if (resultado >= 0.7) {
            txtResultado.text = "É melhor abastecer com gasolina"
        } else {
            txtResultado.text = "É melhor abastecer com álcool"
        }
    }


}