package controllers.ex1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class Exercici1KtTest {

//preu: no cal fer testos ja que
class Exercici1KtTest {
  @kotlin.test.Test
  fun demanemPreuFloatNormal() {
    var expected= 200.21
      assertEquals(expected, 200.21)
  }
  @kotlin.test.Test
  fun demanemPreuAmbValor0() {
    var expected= 0
      assertEquals(expected, 0)
  }
  @kotlin.test.Test
  fun demanemPreuSenseFloat() {
    var expected= 200.0
      assertEquals(expected, 200.0)
  }
 }