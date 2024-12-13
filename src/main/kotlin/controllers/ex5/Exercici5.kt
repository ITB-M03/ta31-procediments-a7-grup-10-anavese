package controllers.ex5
import controllers.ex2.cerrarScanner
import controllers.ex2.demanarNumero
import org.example.controllers.obrimScanner
import java.util.*

data class Pila(
    var top: Int,
    var pila: IntArray,
    var capacitat: Int
)

fun main() {
    val sc: Scanner = obrimScanner()

    //definim array amb piles
    var pilas = crearPila()

    //definim menu
    gestionarOpcions(sc, pilas)

    //definim capacitat
    cerrarScanner(sc)

}

fun crearPila(): Pila {

    var p = Pila(-1, IntArray(10), 10)

    return p
}

fun mostrarMenu() {
    println("Menu d'opcions:")
    println("1.- Afegir número (push)")
    println("2.- Treure número (pop)")
    println("3.- Mostrar contingut de la pila")
    println("4.- Sortir")
}

fun push(p: Pila, num: Int) {

    if (p.top == 9) {
        println("La pila esta plena")
    } else {
        p.top++
        p.pila[p.top] = num
    }
}

fun mostrarContingut(pila: Pila) {
    if (pila.top < 0) { //posicio 0 == quantitat 1
        println("La pila està buida")
    } else {
        for (i in 0..pila.top) {
            print("${pila.pila[i]} ")
        }
    }
    println()
}

fun pop(p: Pila) {
    if (p.top < 0) {
        println("La pila està buida")
    } else {
        p.top--
    }
}

fun gestionarOpcions(sc: Scanner, p: Pila) {
    var sortir = false
    while (!sortir) {
        mostrarMenu() // Mostrem el menú
        print("Escull una opció: ")
        when (sc.nextInt()) {
            1 -> {
                print("Introdueix un número: ")
                val valor = sc.nextInt()
                push(p, valor)
            }

            2 -> pop(p)
            3 -> mostrarContingut(p)
            4 -> sortir = true
            else -> println("Opció no vàlida!")
        }
    }
}
