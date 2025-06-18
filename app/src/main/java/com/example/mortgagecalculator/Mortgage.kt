package com.example.mortgagecalculator

import java.text.DecimalFormat
import kotlin.math.pow

class Mortgage(
    var amount: Float = 100_000f,
    var years: Int   = 30,
    var rate: Float  = 0.035f
) {
    private val fmt = DecimalFormat("$#,##0.00")

    fun monthlyPayment(): Float {
        if (rate <= 0f) return 0f
        val mRate = rate / 12
        val n = years * 12
        val temp = (1 / (1 + mRate).toDouble()).pow(n.toDouble())
        return amount * mRate / (1 - temp.toFloat())
    }

    fun formattedPayment(): String = fmt.format(monthlyPayment())

    fun totalPayment(): Float = monthlyPayment() * years * 12

    fun formattedTotalPayment(): String = fmt.format(totalPayment())
}
