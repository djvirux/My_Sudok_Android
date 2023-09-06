/*
 * *
 * Created by VrX on 6/9/23 20:49
 * Copyright (c) 2023
 * Last modified 6/9/23 20:38
 * /
 */


package com.example .mysudok



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {


    //variable para el nivel seleccionado, por defecto facil
    private var level:String = "20"

    //Botones layout
    private var btnLow:Button? = null
    private var btnLowPlus:Button? = null
    private var btnMedium:Button? = null
    private var btnMediumPlus:Button? = null
    private var btnHigh:Button? = null
    private var btnHighPlus:Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Asignamos los ids a los botones
        btnLow = findViewById(R.id.btn_low)
        btnLowPlus = findViewById(R.id.btn_lowplus)
        btnMedium = findViewById(R.id.btn_medium)
        btnMediumPlus = findViewById(R.id.btn_mediumplus)
        btnHigh = findViewById(R.id.btn_high)
        btnHighPlus = findViewById(R.id.btn_highplus)


        //listener boton Low
        btnLow?.setOnClickListener {
            level = "20"
            nextscreen()
        }

        //listener boton Low Plus
        btnLowPlus?.setOnClickListener {
            level = "30"
            nextscreen()
        }
        //listener boton Medium
        btnMedium?.setOnClickListener {
            level = "40"
            nextscreen()
        }
        //listener boton Medium Plus
        btnMediumPlus?.setOnClickListener {
            level = "50"
            nextscreen()
        }
        //listener boton High
        btnHigh?.setOnClickListener {
            level = "55"
            nextscreen()
        }
        //listener boton High Plus
        btnHighPlus?.setOnClickListener {
            level = "60"
            nextscreen()
        }


    }

    //funcion para pasar a la siguiente pantalla, pasamos datos al activity para decir el nivel
    // seleccionado, por defecto es facil
    private fun nextscreen(){
        val intent = Intent(this, BoardActivity::class.java)
        intent.putExtra("level",level)
        startActivity(intent)
    }

}
