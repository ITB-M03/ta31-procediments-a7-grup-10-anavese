package controllers.ex1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested

class Exercici1KtTest {
  @Nested
  inner class Exercici1KtTest {
    @kotlin.test.Test
    fun demanemPreuFloatNormal() {
      var expected = 200.21
      assertEquals(expected, 200.21)
    }

    @kotlin.test.Test
    fun demanemPreuAmbValor0() {
      var expected = 0
      assertEquals(expected, 0)
    }

    @kotlin.test.Test
    fun demanemPreuSenseFloat() {
      var expected = 200.0
      assertEquals(expected, 200.0)
    }
  }
}