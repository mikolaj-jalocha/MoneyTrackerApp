package com.mj.moneytrackerapp.ui.utils

import java.text.NumberFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale


private val DATE_TIME_FORMATTER: DateTimeFormatter =
    DateTimeFormatter.ofPattern("HH:mm - d MMMM", Locale.getDefault())

private fun formatExpenseDate(date: LocalDateTime): String =
    date.format(DATE_TIME_FORMATTER)

private fun formatCurrency(amount: Double): String =
    NumberFormat.getCurrencyInstance(Locale.getDefault()).format(amount)

fun Double.toCurrencyString(): String = formatCurrency(this)
fun LocalDateTime.toExpenseDateString(): String = formatExpenseDate(this)
