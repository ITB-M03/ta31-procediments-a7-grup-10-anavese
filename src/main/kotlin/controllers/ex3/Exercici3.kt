package controllers.ex3

import controllers.ex2.*
import java.util.*

const val password: String = "VolemGatchapoints"
fun main() {
    var scan = abrirScanner()
    var intent = validarSuperusuari("Introdueïx una contrasenya: ",scan)
    imprimirIntent(intent)
    cerrarScanner(scan)
}

/**
 * Funció que demana i comprova si la contrasenya introduïda coincideix amb l'emmagatzemada
 * @param msg Imprimim un misatge
 * @param scan Escaneja el següent String
 * @return Boolean amb el resultat de la comparació
 * @author Anabel
 */
fun validarSuperusuari(msg : String, scan : Scanner): Boolean {
    var acumuladorIntents : Int = 0
    var encertat: Boolean = false
    print(msg)

    do {
        var contrasenya: String = scan.nextLine()
        if (password.equals(contrasenya)) {
            encertat = true
        }
        else println("Torna a intentar-ho")
        acumuladorIntents++
    }while (acumuladorIntents != 3)
    return encertat
}

/**
 * Funció per imprimir l'intent encertat
 * @param resultat Resultat de la comparació en la funció validarSuperusuari
 * @author Anabel
 */
fun imprimirIntent(resultat: Boolean) {
    if (resultat) {
        println("Ens els mereixem")
    }
}