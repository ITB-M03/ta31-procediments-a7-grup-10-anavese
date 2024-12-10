package controllers.ex2

import java.util.*

fun main() {
    var scan = abrirScanner()
    var num = demanarNumero("Introdueïx un número entre 1 i 3999 per convertir-ho a número romà: ", scan)
    var numRoma = roman(num)
    imprimimResultat(numRoma)
    cerrarScanner(scan)
}

/**
 * Funció per obrir l'escaner
 *@return Scanner obert
 * @author Anabel
 */

fun abrirScanner(): Scanner {
    var scan: Scanner = Scanner(System.`in`)
    return scan
}

/**
 * Envia un mistage i demana un número
 * @param msg Imprimim un misatge
 * @param scan Escaneja el següent número
 * @return número introduït
 * @author Anabel
 */
fun demanarNumero(msg: String, scan: Scanner): Int {
    var numero: Int

    print(msg)
    numero = scan.nextInt()

    return numero
}

/**
 * Funció per convertir un número a número romà
 * @param num Número introduït a transformar
 * @return Número transformat a número romà
 * @author Anabel
 */
fun roman(num: Int): String {
    var unidad = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    var decena = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    var centena = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")

    var milers = ""
    var resto = num
    var milesCount = resto / 1000
    resto %= 1000

    var centenes = resto / 100
    resto %= 100

    var decenes = resto / 10
    resto %= 10

    var unitats = resto

    for (i in 1..milesCount) {
        milers += "M"
    }

    return milers + centena[centenes] + decena[decenes] + unidad[unitats]
}

/**
 * Funció per imprimir el resultat de la conversió
 * @param resultat és el resultat de la conversió a número romà
 * @author Anabel
 */
fun imprimimResultat(resultat: String) {
    print(resultat)
}

/**
 * Funció per tancar l'escaner
 * @param Scanner tancem Scanner
 * @author Anabel
 */
fun cerrarScanner(scan: Scanner) {
    scan.close()
}