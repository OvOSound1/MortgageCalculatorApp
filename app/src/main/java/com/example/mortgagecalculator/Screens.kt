package com.example.mortgagecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(vm: MortgageViewModel, onModify: () -> Unit) {
    Column(
        Modifier
            .background(Color(0xFF16681A))
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Mortgage Calculator",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFFFFFFFF)
            )
        }
        Spacer(Modifier.height(24.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Amount: $${vm.amount}", color = Color(0xFF000000))
                Spacer(Modifier.height(8.dp))
                Text("Years: ${vm.years}", color = Color(0xFF000000))
                Spacer(Modifier.height(8.dp))
                Text("Interest Rate: ${vm.rate}", color = Color(0xFF000000))
            }
        }
        Spacer(Modifier.height(20.dp))
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 2.dp,
            color = Color.White
        )
        Spacer(Modifier.height(12.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Monthly Payment: ${vm.mortgage.formattedPayment()}", color = Color(0xFF000000))
                Spacer(Modifier.height(12.dp))
                Text("Total Payment:   ${vm.mortgage.formattedTotalPayment()}", color = Color(
                    0xFF000000
                )
                )
            }
        }
        Spacer(Modifier.weight(1f))
        Spacer(Modifier.height(32.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onModify,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF195532))
            ) {
                Text("Modify Data")
            }
        }
        Spacer(Modifier.height(430.dp))
        Box(
            Modifier
                .fillMaxWidth()
                .height(0.dp)
                .background(Color(0xFF195532))
        ) {}
    }
}

@Composable
fun InputScreen(vm: MortgageViewModel, onDone: () -> Unit) {
    Column(
        Modifier
            .background(Color(0xFF16681A))
            .padding(50.dp)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Mortgage Calculator",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFFFFFFFF)
            )
        }
        Spacer(Modifier.height(24.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF195532)),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Years", color = Color.White, style = MaterialTheme.typography.bodyLarge)
                Spacer(Modifier.height(8.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val yearOptions = listOf("10", "15", "30")
                    val yearButtonColor = Color(0xFFFFFFFF)
                    val yearRadioColor = Color(0xFF000000)
                    val yearRadioSize = 20.dp
                    val yearTextSize = 18.sp
                    yearOptions.forEach { year ->
                        val isSelected = vm.years == year
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        ) {
                            RadioButton(
                                selected = isSelected,
                                onClick = { vm.years = year },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = yearRadioColor,
                                    unselectedColor = Color(0xFFFFFFFF)
                                ),
                                modifier = Modifier.size(yearRadioSize)
                            )
                            Text(
                                text = year,
                                color = yearButtonColor,
                                fontSize = yearTextSize,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(12.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF195532)),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Amount", color = Color(0xFFFFFFFF))
                Spacer(Modifier.height(8.dp))
                TextField(
                    value = vm.amount,
                    onValueChange = { vm.amount = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )
            }
        }
        Spacer(Modifier.height(12.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF195532)),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Interest Rate %", color = Color(0xFFFFFFFF))
                Spacer(Modifier.height(8.dp))
                TextField(
                    value = vm.rate,
                    onValueChange = { vm.rate = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )
            }
        }
        Spacer(Modifier.height(20.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onDone,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF195532))
            ) {
                Text("Done")
            }
        }
        Spacer(Modifier.height(12.dp))
        Box(
            Modifier
                .fillMaxWidth()
                .height(500.dp)
                .background(Color(0xFF16681A))
        ) {}
    }
}
