package com.example.parcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var num1: String? = ""
    private var num2: String? = ""
    private var num3: String? = ""
    private var res: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input1: EditText = findViewById(R.id.input1)
        val input2: EditText = findViewById(R.id.input2)
        val input3: EditText = findViewById(R.id.input3)
        val resultado: TextView = findViewById(R.id.Resultado)
        val btnCLR: Button = findViewById(R.id.Clear)
        val btnAdd: Button = findViewById(R.id.Agregar)

        input1.text.clear()
        input2.text.clear()
        input3.text.clear()
        resultado.setText("")
        resultado.movementMethod = ScrollingMovementMethod()

        btnCLR.setOnClickListener {
            num1 = ""
            num2 = ""
            num3 = ""
            input1.text.clear()
            input2.text.clear()
            input3.text.clear()
            resultado.setText("")
        }

        btnAdd.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                num1 = input1.text.toString()
                num2 = input2.text.toString()
                num3 = input3.text.toString()

                if(input1.text.toString() == "" || input2.text.toString() == "" || input3.text.toString() == "")
                {
                    resultado.setText("No se puede mostrar un resultado si hay alguna variable vacia")
                }
                else
                {
                    resultado.setText("${input1.text} + ${input2.text} = ${input3.text}")
                    resultado.append("\n")
                    input1.text.clear()
                    input2.text.clear()
                    input3.text.clear()
                    res = num1!!.toInt() + num2!!.toInt()
                    if(res != num3!!.toInt())
                    {
                        resultado.append("El resultado obtenido no concuerda con el resultado ingresado")
                    }
                    else{
                        resultado.append("El resultado obtenido concuerda con el resultado ingresado")
                    }
                }
            }
        })
    }
}
