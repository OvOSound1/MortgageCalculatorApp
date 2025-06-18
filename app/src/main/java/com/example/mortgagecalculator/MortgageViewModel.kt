package com.example.mortgagecalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MortgageViewModel : ViewModel() {
    var mortgage by mutableStateOf(Mortgage())
    var amount   by mutableStateOf(mortgage.amount.toString())
    var years    by mutableStateOf(mortgage.years.toString())
    var rate     by mutableStateOf((mortgage.rate * 100).toString())

    fun updateMortgage() {
        mortgage.amount = amount.toFloatOrNull() ?: mortgage.amount
        mortgage.years  = years.toIntOrNull()   ?: mortgage.years
        mortgage.rate   = (rate.toFloatOrNull() ?: (mortgage.rate * 100)) / 100

        amount = mortgage.amount.toString()
        years  = mortgage.years.toString()
        rate   = (mortgage.rate * 100).toString()
    }
}
