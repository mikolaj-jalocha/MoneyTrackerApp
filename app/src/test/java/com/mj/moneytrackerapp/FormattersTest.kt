package com.mj.moneytrackerapp

import com.mj.moneytrackerapp.ui.utils.toCurrencyString
import com.mj.moneytrackerapp.ui.utils.toExpenseDateString
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.LocalDateTime
import java.util.Locale

class FormattersTest {

    private lateinit var previousLocale: Locale

    @Before
    fun setUp() {
        previousLocale = Locale.getDefault()
        Locale.setDefault(Locale.forLanguageTag("pl-PL"))
    }

    @After
    fun tearDown() {
        Locale.setDefault(previousLocale)
    }

    @Test
    fun `toCurrencyString formats value as USD`() {
        val amount = 26.0
        val expected = "26,00 zł"
        assertEquals(expected, amount.toCurrencyString())
    }

    @Test
    fun `toExpenseDateString formats LocalDateTime using pattern HHmm - d MMMM`() {
        val date = LocalDateTime.of(2023, 4, 30, 18, 27)
        val expected = "18:27 - 30 kwietnia"
        assertEquals(expected, date.toExpenseDateString())
    }

    @Test
    fun `toCurrencyString handles fractional values`() {
        val amount = 1234.56
        val expected = "1 234,56 zł"
        assertEquals(expected, amount.toCurrencyString())
    }
}
