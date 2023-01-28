package com.developerapplications.calculatorapp

import android.os.Bundle
import android.widget.ToggleButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developerapplications.calculatorapp.ui.theme.CalculatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Arithmetic()
                }
            }
        }
    }
}

@Composable
fun Arithmetic() {
    var number1 by remember{ mutableStateOf(TextFieldValue("")) }
    var number2 by remember{ mutableStateOf(TextFieldValue(""))}
    var sum by rememberSaveable{mutableStateOf(0)}
    Column {
        Text(
            AnnotatedString(text = "This is an app to calculate and do Basic Arithmetic\n Operations."),
        Modifier.offset(20.dp,20.dp),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
            )
        Spacer(modifier = Modifier.height(35.dp))

        OutlinedTextField(
            value = number1,
            onValueChange = {number1 = it},
            label = { Text(text = "Number1")},
            placeholder = {
                Text(text = "Enter an Integer,Float or Double")
            },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = number2,
            onValueChange = {number2 = it},
            label = { Text(text = "Number2")},
            placeholder = { Text(text = "Enter an Integer,Float or Double")},
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)

        )

        Button(modifier = Modifier.offset(20.dp,30.dp),onClick = {  }) {
            Text(text = "The Sum of the two Numbers = $sum")
        }
        Spacer(modifier = Modifier.height(40.dp))

        Button(modifier = Modifier.offset(120.dp,10.dp), onClick = {

            val num = number1.text.toInt()
            val numb = number2.text.toInt()

            if (num != 0 && numb != 0){
               sum = num + numb

            }

        },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary))
        {
            Text(text = "Sum")
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorAppTheme {
        Arithmetic()
    }
}