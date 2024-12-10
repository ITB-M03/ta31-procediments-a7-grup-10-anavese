package org.example.controllers
import java.util.*


fun main() {
    val sc: Scanner = obrimScanner()

    // Demanem la data
    var day = sc.nextInt()
    print("Escriu el dia de la compra: ")
    var month = sc.nextInt()
    print("Escriu el mes de la compra: ")
    var year = sc.nextInt()
    print("Escriu l'any de la compra: ")

}
fun obrimScanner(): Scanner {
    return Scanner(System.`in`)
}

/**
 * Funció per llegir els números
 */
fun data(sc:Scanner, msg: String, dia:Int, mes:Int, any:Int): String {
    print(msg)
    var data=Calendar.getInstance()
    var ndia= data.get(Calendar.DAY_OF_YEAR)
    var nmes= data.get(Calendar.MONTH)
    var nany= data.get(Calendar.YEAR)

    return "$ndia-$nmes-$nany"
}

