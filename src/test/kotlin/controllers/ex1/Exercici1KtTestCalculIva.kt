package controllers.ex1
import org.example.controllers.calculIva
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.time.LocalDate
import java.time.Month

class Exercici1KtTestCalculIva {

    @Test
    fun testCalculIvaAmbIvaDesconegut() {
        val data = LocalDate.of(2000, Month.JANUARY, 1)
        val preu = 500f
        val tipusIva = "desconegut"
        val expected = 500f

        val actual = calculIva(data, preu, tipusIva)

        assertEquals(expected, actual, 500f)
    }

    @Test
    fun testCalculIvaReduit15_07_2012() {
        val data = LocalDate.of(2012, Month.JULY, 15)
        val preu = 500.0f
        val tipusIva = "reduit"
        val expected = 550.0f

        val actual = calculIva(data, preu, tipusIva)

        assertEquals(expected, actual, 550.0f)
    }

    @Test
    fun testCalculIvaSueduit() {
        val data = LocalDate.of(1994, Month.JULY, 14)
        val preu = 500.0f
        val tipusIva = "supereduit"
        val expected = 515.0f

        val actual = calculIva(data, preu, tipusIva)

        assertEquals(expected, actual, 515.0f)
    }
}