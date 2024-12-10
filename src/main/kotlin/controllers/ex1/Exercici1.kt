package org.example.controllers
import java.util.*


fun main() {
    val sc: Scanner = obrimScanner()

    //Definim preu
    var preu=preu(sc, "Escriu el preu: ")

    //Demanem Data
    val(dia, mes, any)= data(sc)

    //demanem el tipus d'IVA
    var tipusIva= tipusIva()

    //resultat amb el calcul de l'IVA
    var resultat = calculIva(dia, mes, any, preu, tipusIva)

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

    var num:Float
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
fun data(sc:Scanner):Triple<Int, Int, Int> {
    print("Escriu el dia de la compra: ")
    var dia=sc.nextInt()
    print("Escriu el mes de la compra: ")
    var mes=sc.nextInt()
    print("Escriu l'any de la compra: ")
    var any=sc.nextInt()
    sc.nextLine()
    return Triple(dia,mes,any)
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
    return sc.next().lowercase()
}

/**
 * Funcio per a calcular is es un any de Traspas o no. Ja que desde el 1986 tenim 10 opcions on febrer tindra 29 dies i no 28
 * @author Catalina
 *
 * @param any per veure si es o no de traspas
 * @return tornara un boolean que dira si es o no un any de traspas
 *
 */
fun anyTraspàs(any:Int): Boolean {
    var anyTraspas=false
    if(any %4 ==0 && any%100 !=0 && any%400==0){
        anyTraspas=true
    }
    return anyTraspas
}
/**
 *  Funció per a validar la data. Es a dir, mirem de que els dies corresponguin amb els mesos
 *  @author Catalina
 *
 *  @param dia
 *  @param mes
 *  @param any
 *
 *  @return un boolean que ens dirà si la data existeix o no
 */
fun validemData(dia:Int, mes:Int, any:Int):Boolean {
    var dataValida=false
     when (mes) {
        2 -> dia <= if (anyTraspàs(any)) 29 else 28
        4, 6, 9, 11 -> dia <= 30
        else -> dia <= 31
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
fun obtenimPocentatge(any:Int, tipusIva:String): Float? {
    return when (any) {
        in 1986..1992 -> when (tipusIva) {
            "general" -> 0.12f
            "reduida" -> 0.06f
            else -> null
        }

        in 1993..1995 -> when (tipusIva) {
            "general" -> 0.15f
            "reduida" -> 0.06f
            "superreduida" -> 0.03f
            else -> null
        }

        in 1996..2010 -> when (tipusIva) {
            "general" -> 0.16f
            "reduida" -> 0.07f
            "superreduida" -> 0.04f
            else -> null
        }

        in 2010..2012 -> when (tipusIva) {
            "general" -> 0.18f
            "reduida" -> 0.08f
            "superreduida" -> 0.04f
            else -> null
        }

        in 2012..Int.MAX_VALUE -> when (tipusIva) {
            "general" -> 0.21f
            "reduida" -> 0.10f
            "superreduida" -> 0.04f
            else -> null
        }

        else -> null
    }
}

fun calculIva(dia:Int, mes:Int, any:Int, preu:Float, tipusIva: String): Float? {
    if(validemData(dia,mes,any)) return null
    var porcentatgeIva= obtenimPocentatge(any, tipusIva) ?: return null
    return preu*(1+porcentatgeIva)
}

fun finalscan(sc: Scanner) {
    sc.close()
}