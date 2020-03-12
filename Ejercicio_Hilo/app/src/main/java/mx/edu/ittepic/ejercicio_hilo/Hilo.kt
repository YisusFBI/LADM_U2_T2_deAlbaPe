package mx.edu.ittepic.ejercicio_hilo

class Hilo(p:MainActivity):Thread() {
    var puntero = p
    var iniciado = false
    var pausado = false
    var detenido = false

    override fun run() {
        super.run()
        iniciado = true
        while (iniciado) {
            sleep(1000)
            if(!pausado) {
                puntero.runOnUiThread {
                    //Aquí se pone los cambios a realizar en la interfaz
                    puntero.metodo()
                }
            }
        }
    }

    fun estadoIniciado():Boolean{
        return iniciado
    }

    fun estadoPausado():Boolean{
        return pausado
    }

    fun estadoDetenido():Boolean{
        return detenido
    }

    fun iniciar(){
        start()
    }

    fun pausar(){
        pausado = true
    }

    fun despausar(){
        pausado = false
    }

    fun reiniciar(){
        puntero.resetear()
    }

    fun detener(){
        if(!detenido) {
            iniciado = false
            detenido = true
        }
    }
}