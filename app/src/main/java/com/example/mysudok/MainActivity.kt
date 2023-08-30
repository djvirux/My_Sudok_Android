
package com.example .mysudok



import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    //contiene todos los numeros del tablero del sudoku, para despues poder verificar el sudoku
    private val numerosTableroSudoku = IntArray(81)
    //contiene los numeros a poner en las celdas, menos las celdas en blanco
    private val numerosSudoku = IntArray(81)
    //variable para las victorias, perdidas y ayudas
    private var wins:Int = 0
    private var loose:Int = 0
    private var hint:Int = 3
    //variable para saber el boton en el que estamos
    private var botonSeleccionado: Button? = null
    //variable donde almacenamos todos los botones del tablero del sudoku
    private val botones: ArrayList<Button> = ArrayList()
    //Botones layout
    private var btn1:Button? = null
    private var btn2:Button? = null
    private var btn3:Button? = null
    private var btn4:Button? = null
    private var btn5:Button? = null
    private var btn6:Button? = null
    private var btn7:Button? = null
    private var btn8:Button? = null
    private var btn9:Button? = null
    private var btnBack:Button? = null
    private var btnHint:Button? = null
    private var btnFinsish:Button? = null
    private var btnHome:Button? = null
    private var btnNew:Button? = null
    private var btnCount:Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)


        //Asignamos los ids a los botones
        btnCount = findViewById(R.id.btn_count)
        btnNew = findViewById(R.id.btn_new)
        btnHome = findViewById(R.id.btn_home)
        btn1 = findViewById(R.id.btn_1)
        btn2 = findViewById(R.id.btn_2)
        btn3 = findViewById(R.id.btn_3)
        btn4 = findViewById(R.id.btn_4)
        btn5 = findViewById(R.id.btn_5)
        btn6 = findViewById(R.id.btn_6)
        btn7 = findViewById(R.id.btn_7)
        btn8 = findViewById(R.id.btn_8)
        btn9 = findViewById(R.id.btn_9)
        btnBack = findViewById(R.id.btn_back)
        btnHint = findViewById(R.id.btn_hint)
        btnFinsish = findViewById(R.id.btn_finish)

        // Vincular los botones del tablero del sudoku por su ID
        for (i in 1..81) {
            val buttonId = resources.getIdentifier("b$i", "id", packageName)
            val button = findViewById<Button>(buttonId)
            botones.add(button)
        }

        //listener boton Home
        btnHome?.setOnClickListener {
            Toast.makeText(this, getString(R.string.future_upgrade), Toast.LENGTH_SHORT).show()
        }

        //listener boton New
        btnNew?.setOnClickListener {
            new()
        }

        //listener boton Back
        btnBack?.setOnClickListener {
            back()
        }

        //listener boton Hint
        btnHint?.setOnClickListener {
            hint()
        }

        //listener boton Finish
        btnFinsish?.setOnClickListener {
            verificar()
        }

        //Generamos los listener de los botones desde funcion
        listeners()

        //iniciamos un nuevo juego
        new()
   }

    private fun back(){
        Toast.makeText(this, getString(R.string.future_upgrade), Toast.LENGTH_SHORT).show()
    }

    private fun hint(){
        for(i in botones.indices){
            if(botones[i].equals(botonSeleccionado)){
                if(hint > 0 && botones[i].text==""){
                    botones[i].text = numerosTableroSudoku[i].toString()
                    hint --
                }
            }
        }
        if(hint == 3){
            btnHint?.text = getString(R.string.btn_hint_3)
        }else if(hint == 2){
            btnHint?.text = getString(R.string.btn_hint_2)
        }else if(hint == 1){
            btnHint?.text = getString(R.string.btn_hint_1)
        }else {
            Toast.makeText(this, getString(R.string.future_upgrade), Toast.LENGTH_SHORT).show()
            btnHint?.text = getString(R.string.btn_hint_0)
        }
    }


   private fun verificar() {

       botonSeleccionado = null
       var error = 0
       try{
           for (i in numerosTableroSudoku.indices){
               var textoBoton = botones[i].text.toString()
               if (textoBoton.equals("")){
                   textoBoton="0"
               }
               val numeroBoton = textoBoton.toInt()

               if (numerosSudoku[i] == 0) {
                   if (numerosTableroSudoku[i] == numeroBoton) {
                       //si el numero es correcto pintamos su celda de verde
                       botones[i].background = ContextCompat.getDrawable(this, R.drawable.blackbrdgreen)
                   } else {
                       botones[i].background = ContextCompat.getDrawable(this, R.drawable.redborder)
                       error ++
                   }
               }
           }
       }catch (e: NumberFormatException){
           //Error en formato de numero, no deberiamos llegar nunca, ya que si tenemos un nulo
           // le asignamos cero
       }

       //Si hemos tenido errores sumamos una perdida, si no una victoria.
       if (error > 0){
           loose ++
       }else{
           wins ++
           new()
       }

       //Actualizamos conteo
        btnCount?.text=String.format(getString(R.string.btn_count_up),wins,loose)

   }

   private fun listeners(){
       for (i in botones.indices) {

               val button = botones[i]

               button.setOnClickListener {

                   if (numerosSudoku[i]==0) {

                       // Restaurar el drawable original del botón anterior
                       //botonSeleccionado?.background = drawablesOriginales[botonSeleccionado]
                       botonSeleccionado?.background = ContextCompat.getDrawable(this, R.drawable.blackbrdgrey)
                       // Cambiar el drawable del botón actual
                       button.setBackgroundColor(getColor(R.color.gris_celda))
                       // Actualizar el botón seleccionado
                       botonSeleccionado = button

                       btn1?.setOnClickListener { button.text = "1" }
                       btn2?.setOnClickListener { button.text = "2" }
                       btn3?.setOnClickListener { button.text = "3" }
                       btn4?.setOnClickListener { button.text = "4" }
                       btn5?.setOnClickListener { button.text = "5" }
                       btn6?.setOnClickListener { button.text = "6" }
                       btn7?.setOnClickListener { button.text = "7" }
                       btn8?.setOnClickListener { button.text = "8" }
                       btn9?.setOnClickListener { button.text = "9" }

                   }

               }

       }
   }


   private fun new() {

       botonSeleccionado = null
       board()
       takeaway()
       //ponemos el texto al sudoku
       for (i in botones.indices) {
           if (numerosSudoku[i] == 0) {
               botones[i].text = ""
               botones[i].background = ContextCompat.getDrawable(this, R.drawable.blackborder)
           } else {
               botones[i].text = numerosSudoku[i].toString()
               botones[i].background = ContextCompat.getDrawable(this, R.drawable.blackborder)
           }
       }
   }


    //Funcion para generar los numeros del tablero de sudoku
   private fun board() {

       //variables para generar los numeros aleatoriamente
       val d = Random.nextInt(1..9)
       val e = Random.nextInt(1..9)
       val f = Random.nextInt(1..9)
       val i = Random.nextInt(1..9)
       val j = Random.nextInt(1..9)
       val k = Random.nextInt(1..9)
       val l = Random.nextInt(1..9)
       val m = Random.nextInt(1..9)
       val n = Random.nextInt(1..9)

       //verificamos que no tenemos datos repetidos en los numeros aleatorios
       if (d != e && d != f && f != e) {
           if (i != j && i != k && k != j && d != i && d != j && d != k && e != i && e != j && e != k && f != i && f != j && f != k) {
               if (l != m && l != n && n != m && d != l && d != m && d != n && e != l && e != m && e != n && f != l && f != m && f != n && i != l && i != m && i != n && j != l && j != m && j != n && k != l && k != m && k != n) {

                   //generamos un array temporal con los numeros del sudoku
                   val arraytemp = arrayOf(
                       d, f, k, e, n, l, m, i, j,//block1
                       i, l, m, d, k, j, f, n, e,//block2
                       j, e, n, i, m, f, k, d, l,//block3
                       k, m, f, i, j, n, l, e, d,//block4
                       l, e, n, k, d, f, m, j, i,//block5
                       d, i, j, e, l, m, f, n, k,//block6
                       j, d, i, f, l, m, n, k, e,//block7
                       n, f, l, e, i, k, j, m, d,//block8
                       m, k, e, n, j, d, l, f, i //block9
                   )
                   //asignamos el array temporal al array de los numeros del sudoku para el tratamiento en el resto de la app
                   for (t in arraytemp.indices) {
                       numerosTableroSudoku[t] = arraytemp[t]
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


    //Funcion para generar los numeros que eliminamos del tablero de sudoku
   private fun takeaway() {

       //Generamos una lista de numeros aleatorios y unicos, para despues no poner texto sobre esas celdas
       val random = Random(System.currentTimeMillis())
       val numerosUnicos = mutableSetOf<Int>()

       while (numerosUnicos.size < 10) {
           val quitarCeldas = random.nextInt(0, 82)
           numerosUnicos.add(quitarCeldas)
       }

        //Los numeros que queremos eliminar los igualmos a cero para su posterior tratamiento.
       for (i in numerosTableroSudoku.indices) {
           if (numerosUnicos.contains(i)) {
               numerosSudoku[i] = 0
           }else{
               numerosSudoku[i] = numerosTableroSudoku[i]
           }
       }

   }

}






