package controllers.ex4

import controllers.ex2.*
import java.util.Scanner


fun main() {
    var scan = abrirScanner()
    var text = demanarFrase ("Introdueix el text que vols centrar: ", scan)
    titol(text)
    cerrarScanner(scan)
}

/**
 * Funció per demanar una frase per teclat
 * @param msg Imprimim un misatge per pantalla
 * @param scan Introduïm una frase per teclat
 * @return Retorna la frase introduïda
 * @author Anabel
 */
fun demanarFrase(msg: String, scan: Scanner): String {
    print(msg)
    var frase = scan.nextLine()
    return frase
}

/**
 * Funció que imprimeix la frase introduïda per teclat de forma centrada
 * @param text Frase introduïda per teclat
 * @author Anabel
 */
fun titol(text: String) {
    val amplePantalla = 80
    if (text.length > amplePantalla) {
        println(text)
    } else {
        val espais = (amplePantalla - text.length) / 2
        var espaisBuit = ""

        for (i in 1..espais) {
            espaisBuit += " "
        }
        println(espaisBuit + text)
    }
}

