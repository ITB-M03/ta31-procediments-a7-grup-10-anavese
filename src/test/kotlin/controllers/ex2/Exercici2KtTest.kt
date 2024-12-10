package controllers.ex2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class Exercici2KtTest {

@Test
 fun provaRoman() {
  var valorEsperat = "DCXXVIII"

 assertEquals(valorEsperat, roman(628))
 }
  @Test
  fun provaRoman2() {
   var valorEsperat = "MMDCCCL"

   assertEquals(valorEsperat, roman(2850))
  }
  @Test
  fun provaRoman3() {
   var valorEsperat = "DCCLXXVII"

   assertEquals(valorEsperat, roman(777))
  }
}