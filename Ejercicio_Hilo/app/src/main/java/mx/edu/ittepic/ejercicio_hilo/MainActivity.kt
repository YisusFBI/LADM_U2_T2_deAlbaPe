package mx.edu.ittepic.ejercicio_hilo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var texto1 = arrayListOf<String>("⠀¡YO⠀AMO⠀PROGRAMAR!⠀", "¡YO⠀AMO⠀PROGRAMAR!⠀⠀", "YO⠀AMO⠀PROGRAMAR!⠀⠀¡", "O⠀AMO⠀PROGRAMAR!⠀⠀¡Y",
                                             "⠀AMO⠀PROGRAMAR!⠀⠀¡YO", "AMO⠀PROGRAMAR!⠀⠀¡YO⠀", "MO⠀PROGRAMAR!⠀⠀¡YO⠀A", "O⠀PROGRAMAR!⠀⠀¡YO⠀AM",
                                             "⠀PROGRAMAR!⠀⠀¡YO⠀AMO", "PROGRAMAR!⠀⠀¡YO⠀AMO⠀", "ROGRAMAR!⠀⠀¡YO⠀AMO⠀P", "OGRAMAR!⠀⠀¡YO⠀AMO⠀PR",
                                             "GRAMAR!⠀⠀¡YO⠀AMO⠀PRO", "RAMAR!⠀⠀¡YO⠀AMO⠀PROG", "AMAR!⠀⠀¡YO⠀AMO⠀PROGR", "MAR!⠀⠀¡YO⠀AMO⠀PROGRA",
                                             "AR!⠀⠀¡YO⠀AMO⠀PROGRAM", "R!⠀⠀¡YO⠀AMO⠀PROGRAMA", "!⠀⠀¡YO⠀AMO⠀PROGRAMAR", "⠀⠀¡YO⠀AMO⠀PROGRAMAR!")

    private var texto2 = arrayListOf<String>("⠀BIENVENIDOS⠀A⠀LADM⠀", "⠀⠀BIENVENIDOS⠀A⠀LADM", "M⠀⠀BIENVENIDOS⠀A⠀LAD", "DM⠀⠀BIENVENIDOS⠀A⠀LA",
                                             "ADM⠀⠀BIENVENIDOS⠀A⠀L", "LADM⠀⠀BIENVENIDOS⠀A⠀", "⠀LADM⠀⠀BIENVENIDOS⠀A", "A⠀LADM⠀⠀BIENVENIDOS⠀",
                                             "⠀A⠀LADM⠀⠀BIENVENIDOS", "S⠀A⠀LADM⠀⠀BIENVENIDO", "OS⠀A⠀LADM⠀⠀BIENVENID", "DOS⠀A⠀LADM⠀⠀BIENVENI",
                                             "IDOS⠀A⠀LADM⠀⠀BIENVEN", "NIDOS⠀A⠀LADM⠀⠀BIENVE", "ENIDOS⠀A⠀LADM⠀⠀BIENV", "VENIDOS⠀A⠀LADM⠀⠀BIEN",
                                             "NVENIDOS⠀A⠀LADM⠀⠀BIE", "ENVENIDOS⠀A⠀LADM⠀⠀BI", "IENVENIDOS⠀A⠀LADM⠀⠀B", "BIENVENIDOS⠀A⠀LADM⠀⠀")

    private var texto3 = arrayListOf<String>("⠀¡SORBETE DE LIMÓN!⠀", "¡SORBETE DE LIMÓN!⠀⠀", "SORBETE DE LIMÓN!⠀⠀¡", "ORBETE DE LIMÓN!⠀⠀¡S",
                                             "RBETE DE LIMÓN!⠀⠀¡SO", "BETE DE LIMÓN!⠀⠀¡SOR", "ETE DE LIMÓN!⠀⠀¡SORB", "TE DE LIMÓN!⠀⠀¡SORBE",
                                             "E DE LIMÓN!⠀⠀¡SORBET", " DE LIMÓN!⠀⠀¡SORBETE", "DE LIMÓN!⠀⠀¡SORBETE ", "E LIMÓN!⠀⠀¡SORBETE D",
                                             " LIMÓN!⠀⠀¡SORBETE DE", "LIMÓN!⠀⠀¡SORBETE DE ", "IMÓN!⠀⠀¡SORBETE DE L", "MÓN!⠀⠀¡SORBETE DE LI",
                                             "ÓN!⠀⠀¡SORBETE DE LIM", "N!⠀⠀¡SORBETE DE LIMÓ", "!⠀⠀¡SORBETE DE LIMÓN", "⠀⠀¡SORBETE DE LIMÓN!")

    private var posTexto = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var hilo = Hilo(this)
        btnIniciar.setOnClickListener {
            if(!hilo.estadoIniciado())
                hilo.iniciar()
            else
                mensaje("El hilo ya fue iniciado")
        }

        btnPausar.setOnClickListener {
            if(!hilo.estadoPausado())
                hilo.pausar()
            else
                mensaje("El hilo ya fue pausado")
        }

        btnDespausar.setOnClickListener {
            if(hilo.estadoPausado())
                hilo.despausar()
            else
                mensaje("El hilo ya fue despausado")
        }

        btnDetener.setOnClickListener {
            if(!hilo.estadoDetenido())
                hilo.detener()
            else
                mensaje("El hilo ya fue detenido")
        }

        btnReiniciar.setOnClickListener {
            hilo.reiniciar()
        }
    }

    fun metodo(){
        if(posTexto == texto1.size)
            posTexto = 0
        btnTexto.text = texto1[posTexto]
        btnTexto2.text = texto2[posTexto]
        btnTexto3.text = texto3[posTexto]
        posTexto++
    }

    fun resetear(){
        posTexto = 0
        btnTexto.text = texto1[posTexto]
        btnTexto2.text = texto2[posTexto]
        btnTexto3.text = texto3[posTexto]
    }

    private fun mensaje(mensaje:String){
        AlertDialog.Builder(this).
                setTitle("ATENCIÓN").
                setMessage(mensaje).
                setPositiveButton("OK"){id, i->}.
                show()
    }

}