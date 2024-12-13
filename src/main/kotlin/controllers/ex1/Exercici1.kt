package org.example.controllers
import java.time.LocalDate
import java.time.Month
import java.util.*
import java.time.format.DateTimeFormatter


fun main() {
    val sc: Scanner = obrimScanner()

    //Definim preu
    val preu=preu(sc, "Escriu el preu: ")
    sc.nextLine()

    //Demanem Data
    val data= data(sc)

    //demanem el tipus d'IVA
    val tipusIva= tipusIva()

    //resultat amb el calcul de l'IVA
    val resultat = calculIva(data, preu, tipusIva)

    println("El resultat es de: $resultat")

    var tanquemScan= finalscan(sc)



}
fun obrimScanner(): Scanner {
    return Scanner(System.`in`)
}

/**
 * Funció per a demanar el preu
 * @author Catalina
 *
 * @param sc per escanejar el numero
 * @param msg per imprimir un missatge
 * @return el preu que donem al principi per posteriorment calcularli l'IVA
 */
fun preu(sc:Scanner, msg:String): Float{
    print(msg)

    val num:Float
    num=sc.nextFloat()
    return num
}
/**
 * Funció per a demanar la data de la compra
 * @author Catalina
 *
 * @param sc per escanejar el numero
 * @return un triple que conte el dia, el mes i l'any
 */
fun data(sc:Scanner): LocalDate{
    print("Escriu la data de la compra: ")
    val dataString = sc.nextLine()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")//format correcte
    val data= LocalDate.parse(dataString, formatter)//convertim la string a una localdate
    return data
}

/**
 * Funció per a demanar quin tipus d'IVA podem escollir
 *@author Catalina
 *
 * @return mostrara les opcions per a calcular el tipus d'Iva que volem
 *
 */
fun tipusIva(): String {
    val sc:Scanner=Scanner(System.`in`)
    println("Escriu quin tipus d'Iva escolliras : General, Reduit, Superreduit, Exempt")

    var ivaEscollir=sc.next()
    return ivaEscollir.lowercase()
}

/**
 * Funció per a calcular els Ivas
 * @author Catalina
 *
 * @param any que és l'any de la compra
 * @param tipusIva que és el tipus d'IVA que escollirem
 *
 * @return el porcentatge
 */
fun obtenimPocentatge(data:LocalDate, tipusIva:String): Float {
    var any= data.year
    return when (any) {
        //12
        in 1986 until 1992 -> when (tipusIva) {
            "general" -> 1.12f
            "reduit" -> 1.06f
            else -> 1f
        }
        //15
        in 1992..1994 -> when (tipusIva) {
            "general" -> 1.15f
            "reduit" -> 1.06f
            "superreduit" -> 1.03f
            else -> 1f
        }

        in 1995..2009 -> when (tipusIva) {
            "general" -> 1.16f
            "reduit" -> 1.07f
            "superreduit" -> 1.04f
            else -> 1f
        }

        in 2010..2012 -> when (tipusIva) {

            "general" -> 1.18f
            "reduit" -> 1.08f
            "superreduit" -> 1.04f
            else -> 1.0f
        }

        in 2012..Int.MAX_VALUE -> when (tipusIva) {
            "general" -> {
                if (data.dayOfYear < 15 && data.month == Month.JULY && data.year ==2012 ) 1.18f
                else 1.21f
            }
            "reduit" -> {
                if (data.dayOfYear > 15 && data.month >= Month.JULY && data.year ==2012 ) 1.08f
                else 1.10f
            }
            "superreduit" -> 1.04f
            else -> 1.0f
        }
        else -> 1.0f
    }
 }

/**
 * @author Catalina
 *
 * @param data amb la data de la compra
 * @param preu amb el cost de la compra
 * @param tipusIva amb els tipus d'IVA que podem escollir
 *
 * @return el preu final amb l'IVA calculat
 *
 */

fun calculIva(data: LocalDate, preu:Float, tipusIva: String): Float {
    var porcentatgeIva= obtenimPocentatge(data, tipusIva)
    var calcul=preu*porcentatgeIva
    return calcul
}

fun finalscan(sc: Scanner) {
    sc.close()
}