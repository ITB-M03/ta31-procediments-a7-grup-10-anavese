package org.example.controllers
import java.time.LocalDate
import java.time.Month
import java.util.*
import java.time.format.DateTimeFormatter


fun main() {
    val sc: Scanner = obrimScanner()

    //Definim preu
    val preu=preu(sc, "Escriu el preu: ")

    //Demanem Data
    val data= data(sc)

    //demanem el tipus d'IVA
    val tipusIva= tipusIva()

    //resultat amb el calcul de l'IVA
    val resultat = calculIva(data preu, tipusIva)

    //si ek resultat no es null, imprimim el resultat amb l'IVA
    if (resultat != null) println("El preu final amb l'IVA és de: $resultat")
    //si esnullm imprimim que el resultat no es valid
    else println("El resultat es de: $preu")

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
 *  Funció per a validar la data. Es a dir, mirem de que els dies corresponguin amb els mesos
 *  @author Catalina
 *
 *  @param data
 *
 *  @return un boolean que ens dirà si la data existeix o no
 */
fun validemData(data: LocalDate):Boolean {
    var dataValida=false
     when (data.month) {
         Month.FEBRUARY <= 28
         Month.APRIL,  Month.JUNE,  Month.SEPTEMBER,  Month.NOVEMBER -> data.dayOfYear  <= 30
        else -> data.dayOfYear  <= 31
    }
    return dataValida
}

/**
 * Funció per a calcular els Ivas
 * @author Catalina
 *
 * @param any
 * @param tipusIva
 */
fun obtenimPocentatge(data:LocalDate, tipusIva:String): Float? {
    return when (data.year) {
        //12
        in 1986 until 1992 -> when (tipusIva) {
            "general" -> 1.12f
            "reduida" -> 1.06f
            else -> null
        }
        //15
        in 1992..1994 -> when (tipusIva) {
            "general" -> 1.15f
            "reduida" -> 1.06f
            "superreduida" -> 1.03f
            else -> null
        }

        in 1995..2009 -> when (tipusIva) {
            "general" -> 1.16f
            "reduida" -> 1.07f
            "superreduida" -> 1.04f
            else -> null
        }

        in 2010..2012 -> when (tipusIva) {

            "general" -> 1.18f
            "reduida" -> 1.08f
            "superreduida" -> 1.04f
            else -> null
        }

        in 2012..Int.MAX_VALUE -> when (tipusIva) {
            if (data.dayOfYear > 15 && data.month >   ) {
                "general" -> 1.21f
                "reduida" -> 1.10f
                "superreduida" -> 1.04f
                else -> null
            }
        }

        else -> null
    }
}

fun calculIva(data: LocalDate, preu:Float, tipusIva: String): Float? {
    if(validemData(data.dayOfMonth ,data.month,data.year)) return null
    var porcentatgeIva= obtenimPocentatge(data.year, tipusIva) ?: return null
    var calcul=preu*porcentatgeIva
    return calcul
}

fun finalscan(sc: Scanner) {
    sc.close()
}