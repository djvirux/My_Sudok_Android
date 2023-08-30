package com.example.mysudok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.mysudok.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class BoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }




}


/*


package com.example .mysudok


import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.mysudok.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val numeros_sudoku = IntArray(81)

    private val buttons = Array<Button?>(81) { null }

    private val botonesBlanco = mutableSetOf<Int>()

    //private val b = Array<TextView>(81) { null }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar el diseño con Data Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Vincular todos los botones del tablero de sudoku


        for (i in 1..81) {
            val buttonId = resources.getIdentifier("b$i", "id", packageName)
            buttons[i - 1] = findViewById(buttonId)
            val buttonss = findViewById<Button>(buttonId)

            buttonss.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    Toast.makeText(this, "Foco", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No Foco", Toast.LENGTH_SHORT).show()
                    // El botón ha perdido el foco
                }


            }
        }


        //Vincular botones tablero

        /*
        b[0] = findViewById(R.id.b1)
        b[1] = findViewById(R.id.b2)
        b[2] = findViewById(R.id.b3)
        b[3] = findViewById(R.id.b4)
        b[4] = findViewById(R.id.b5)
        b[5] = findViewById(R.id.b6)
        b[6] = findViewById(R.id.b7)
        b[7] = findViewById(R.id.b8)
        b[8] = findViewById(R.id.b9)
        b[9] = findViewById(R.id.b10)
        b[10] = findViewById(R.id.b11)
        b[11] = findViewById(R.id.b12)
        b[12] = findViewById(R.id.b13)
        b[13] = findViewById(R.id.b14)
        b[14] = findViewById(R.id.b15)
        b[15] = findViewById(R.id.b16)
        b[16] = findViewById(R.id.b17)
        b[17] = findViewById(R.id.b18)
        b[18] = findViewById(R.id.b19)
        b[19] = findViewById(R.id.b20)
        b[20] = findViewById(R.id.b21)
        b[21] = findViewById(R.id.b22)
        b[22] = findViewById(R.id.b23)
        b[23] = findViewById(R.id.b24)
        b[24] = findViewById(R.id.b25)
        b[25] = findViewById(R.id.b26)
        b[26] = findViewById(R.id.b27)
        b[27] = findViewById(R.id.b28)
        b[28] = findViewById(R.id.b29)
        b[29] = findViewById(R.id.b30)
        b[30] = findViewById(R.id.b31)
        b[31] = findViewById(R.id.b32)
        b[32] = findViewById(R.id.b33)
        b[33] = findViewById(R.id.b34)
        b[34] = findViewById(R.id.b35)
        b[35] = findViewById(R.id.b36)
        b[36] = findViewById(R.id.b37)
        b[37] = findViewById(R.id.b38)
        b[38] = findViewById(R.id.b39)
        b[39] = findViewById(R.id.b40)
        b[40] = findViewById(R.id.b41)
        b[41] = findViewById(R.id.b42)
        b[42] = findViewById(R.id.b43)
        b[43] = findViewById(R.id.b44)
        b[44] = findViewById(R.id.b45)
        b[45] = findViewById(R.id.b46)
        b[46] = findViewById(R.id.b47)
        b[47] = findViewById(R.id.b48)
        b[48] = findViewById(R.id.b49)
        b[49] = findViewById(R.id.b50)
        b[50] = findViewById(R.id.b51)
        b[51] = findViewById(R.id.b52)
        b[52] = findViewById(R.id.b53)
        b[53] = findViewById(R.id.b54)
        b[54] = findViewById(R.id.b55)
        b[55] = findViewById(R.id.b56)
        b[56] = findViewById(R.id.b57)
        b[57] = findViewById(R.id.b58)
        b[58] = findViewById(R.id.b59)
        b[59] = findViewById(R.id.b60)
        b[60] = findViewById(R.id.b61)
        b[61] = findViewById(R.id.b62)
        b[62] = findViewById(R.id.b63)
        b[63] = findViewById(R.id.b64)
        b[64] = findViewById(R.id.b65)
        b[65] = findViewById(R.id.b66)
        b[66] = findViewById(R.id.b67)
        b[67] = findViewById(R.id.b68)
        b[68] = findViewById(R.id.b69)
        b[69] = findViewById(R.id.b70)
        b[70] = findViewById(R.id.b71)
        b[71] = findViewById(R.id.b72)
        b[72] = findViewById(R.id.b73)
        b[73] = findViewById(R.id.b74)
        b[74] = findViewById(R.id.b75)
        b[75] = findViewById(R.id.b76)
        b[76] = findViewById(R.id.b77)
        b[77] = findViewById(R.id.b78)
        b[78] = findViewById(R.id.b79)
        b[79] = findViewById(R.id.b80)
        b[80] = findViewById(R.id.b81)


         */

        //iniciamos un nuevo juego
        new()

        //
        binding.btnNew.setOnClickListener { new() }

        for (button in buttons) {
            button?.setOnClickListener {


                if (botonesBlanco.contains((it as Button).id)) {


                    button.setBackgroundColor(resources.getColor(R.color.gris_celda))



                    binding.btn1.setOnClickListener { button.text = "1" }
                    binding.btn2.setOnClickListener { button.text = "2" }
                    binding.btn3.setOnClickListener { button.text = "3" }
                    binding.btn4.setOnClickListener { button.text = "4" }
                    binding.btn5.setOnClickListener { button.text = "5" }
                    binding.btn6.setOnClickListener { button.text = "6" }
                    binding.btn7.setOnClickListener { button.text = "7" }
                    binding.btn8.setOnClickListener { button.text = "8" }
                    binding.btn9.setOnClickListener { button.text = "9" }

                    Toast.makeText(this, "Numero no contiene ", Toast.LENGTH_SHORT).show()

                } else {

                    //Toast.makeText(this, "Numero contien ", Toast.LENGTH_SHORT).show()
                }


                /*

                if (textovacio.isEmpty()) {
                    Toast.makeText(this, "Vacio " + contiene + (it as Button).id, Toast.LENGTH_SHORT).show()
                }else{
                        Toast.makeText(this, "I= " + button , Toast.LENGTH_SHORT).show()
                        // Aquí coloca el código que deseas ejecutar cuando se haga clic en un botón
                        // Puedes usar "button" para referirte al botón específico que se ha clicado.
                    }



 */

            }



        }

    }

    private fun new() {
        board()
        takeaway()
    }

    private fun board() {

        //variables para generar los numeros aleatoriamente

        val d = Random.nextInt(1..9);
        val e = Random.nextInt(1..9);
        val f = Random.nextInt(1..9)
        val i = Random.nextInt(1..9);
        val j = Random.nextInt(1..9);
        val k = Random.nextInt(1..9)
        val l = Random.nextInt(1..9);
        val m = Random.nextInt(1..9);
        val n = Random.nextInt(1..9)

        //verificamos que no tenemos datos repetidos en los numeros aleatorios
        if (d != e && d != f && f != e) {
            if (i != j && i != k && k != j && d != i && d != j && d != k && e != i && e != j && e != k && f != i && f != j && f != k) {
                if (l != m && l != n && n != m && d != l && d != m && d != n && e != l && e != m && e != n && f != l && f != m && f != n && i != l && i != m && i != n && j != l && j != m && j != n && k != l && k != m && k != n) {

                    //generamos un array temporal con los numeros del sudoku
                    val arraytemp = arrayOf<Int>(
                        d, f, k, e, n, l, m, i, j,//block1
                        i, l, m, d, k, j, f, n, e,//block2
                        j, e, n, i, m, f, k, d, l,//block3
                        k, m, f, i, j, n, l, e, d,//block4
                        l, e, n, k, d, f, m, j, i,//block5
                        d, i, j, e, l, m, f, n, k,//block6
                        j, d, i, f, l, m, n, k, e,//block7
                        n, f, l, e, i, k, j, m, d,//block8
                        m, k, e, n, j, d, l, f, i
                    )//block9

                    //asignamos el array temporal al array de los numeros del sudoku para el tratamiento en el resto de la app

                    for (t in arraytemp.indices) {
                        numeros_sudoku[t] = arraytemp.get(t)
                    }

                } else if (l == m || l == n || n == m || d == l || d == m || d == n || e == l || e == m || e == n || f == l || f == m || f == n || i == l || i == m || i == n || j == l || j == m || j == n || k == l || k == m || k == n) {
                    board()
                }
            } else if (i == j || i == k || k == j || d == i || d == j || d == k || e == i || e == j || e == k || f == i || f == j || f == k) {
                board()
            }
        } else if (d == e || d == f || f == e) {
            board()
        }
    }


    private fun takeaway() {

        //generamos una lista de numeros aleatorios y no repeditos, para despues no poner texto sobre esas celdas
        val random = Random(System.currentTimeMillis())
        val numerosUnicos = mutableSetOf<Int>()

        while (numerosUnicos.size < 50) {
            val quitarCeldas = random.nextInt(0, 82)
            numerosUnicos.add(quitarCeldas)
        }

        for (i in numeros_sudoku.indices) {
            val button = buttons[i]
            if (numerosUnicos.contains(i)) {
                button?.text = ""
                button?.id?.let { botonesBlanco.add(it.toInt()) }
            } else {
                button?.text = numeros_sudoku.get(i).toString()
            }


            //Toast.makeText(this, "I= " + t + " aytemp" + arraytemp.get(t), Toast.LENGTH_SHORT).show()
            //numeros_sudoku[t] = arraytemp.get(t)
        }

        for (i in numerosUnicos.indices) {

            //button?.text = numeros_sudoku.get(i).toString()
            //Toast.makeText(this, "I= " + t + " aytemp" + arraytemp.get(t), Toast.LENGTH_SHORT).show()
            //numeros_sudoku[t] = arraytemp.get(t)
        }

        buttons

    }

}


/*






private fun board(){

val d = Random.nextInt(1..9);val e = Random.nextInt(1..9);val f = Random.nextInt(1..9)
val i = Random.nextInt(1..9);val j = Random.nextInt(1..9);val k = Random.nextInt(1..9)
val l = Random.nextInt(1..9);val m = Random.nextInt(1..9);val n = Random.nextInt(1..9)

val buttonUsed = arrayListOf<Button>()
val buttonUse = arrayListOf<Button>()
val hi = arrayListOf<Button>(
    binding.b1,binding.b2,binding.b3,binding.b4,binding.b5,binding.b6,binding.b7,binding.b8,binding.b9,
    binding.b10,binding.b11,binding.b12,binding.b13,binding.b14,binding.b15,binding.b16,binding.b17,binding.b18,
    binding.b19,binding.b20,binding.b21,binding.b22,binding.b23,binding.b24,binding.b25,binding.b26,binding.b27,
    binding.b28,binding.b29,binding.b30,binding.b31,binding.b32,binding.b33,binding.b34,binding.b35,binding.b36,
    binding.b37,binding.b38,binding.b39,binding.b40,binding.b41,binding.b42,binding.b43,binding.b44,binding.b45,
    binding.b46,binding.b47,binding.b48,binding.b49,binding.b50,binding.b51,binding.b52,binding.b53,binding.b54,
    binding.b55,binding.b56,binding.b57,binding.b58,binding.b59,binding.b60,binding.b61,binding.b62,binding.b63,
    binding.b64,binding.b65,binding.b66,binding.b67,binding.b68,binding.b69,binding.b70,binding.b71,binding.b72,
    binding.b73,binding.b74,binding.b75,binding.b76,binding.b77,binding.b78,binding.b79,binding.b80,binding.b81
)
var start = 0
val buttonColor = arrayListOf<Int>()
fun keys(buSelected: Button){
    var trats = 0
    var buttonColorSize = buttonColor.size.toInt()

    buSelected.setOnClickListener{
        if(hi.contains(buSelected)){

            buttonUse.add(buSelected)
            buttonUse[0].setBackgroundResource(R.drawable.blackborder)
            buttonUse.remove(buttonUse[0])
            //buttonUsed[0].setBackgroundResource(R.drawable.orangeborder)
        }else{
            buttonUsed.add(buSelected)
            buttonUsed[0].setBackgroundResource(R.drawable.orangeborder)
            buttonUsed.remove(buttonUse[0])
            //buttonUse[0].setBackgroundResource(R.drawable.blackborder)
        }
        Toast.makeText(this, "N" + buttonUse[0].background, Toast.LENGTH_SHORT).show()
        buSelected.setTextColor(resources.getColor(R.color.black))
        //buSelected.setBackgroundColor(resources.getColor(R.color.purple_200))



*/






 */