package com.itiudec.myfirstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edadInput = findViewById<EditText>(R.id.edad_Input)
        val nombreInput = findViewById<EditText>(R.id.nombre_Input)
        val resultadoText = findViewById<TextView>(R.id.resultado_Text)
        var numeroSuerte: Int = 0
        var suma: Int = 0

        val suerte_Button = findViewById<Button>(R.id.suerte_button)
        suerte_Button.setOnClickListener() {
            if (edadInput.text.isEmpty() || nombreInput.text.isEmpty()) {
                Toast.makeText(this, "Please fill all fields...", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Toast.makeText(this, "Good luck!!!", Toast.LENGTH_SHORT).show()
            val numeroAux : Int = edadInput.text.toString().toInt()
            if(numeroAux > 0 && numeroAux < 9 ){
               numeroSuerte =  numeroAux * 7
                suma = 0
                while(numeroSuerte > 0) {
                    suma+= numeroSuerte%10
                    numeroSuerte /= 10
                }
                resultadoText.text ="Welcome ${nombreInput.text} your lucky number is: ${suma.toString()}"
                return@setOnClickListener
            }
            suma=0
            numeroSuerte = numeroAux
            while(numeroSuerte >0){
                suma+=numeroSuerte%10
                numeroSuerte/=10
            }
            resultadoText.text = "Bienvenido ${nombreInput.text} tu numero de la suerte es: ${suma.toString()}"
        }
    }
}