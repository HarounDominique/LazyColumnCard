package com.example.lazycolumncard

import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazycolumncard.ui.theme.LazyColumnCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScaffoldScreen()
                }
            }
        }
    }
}

@Composable
fun ScaffoldScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nombre Apellido") }
            )
        }
    ) {
        MyLazyColumn()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyColumnCardTheme {
        ScaffoldScreen()
    }
}

@Composable
fun MyLazyColumn() {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        // state = rememberLazyListState(),  //
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(messages) { message -> MyComponent(message) }
    }
}


data class MyMessage(val user: Int, val body: String)

val messages: List<MyMessage> = listOf(
    MyMessage(
        user = 0,
        body = "Hola, ¿Has oído hablar de la programación reactiva en Android?"
    ),
    MyMessage(
        user = 1,
        body = "You can think of Modifiers as implementations of the decorator pattern"
    ),
    MyMessage(
        user = 0,
        body = "You can think of Modifiers as implementations of the decorator pattern"
    ),
    MyMessage(
        user = 1,
        body = "You can think of Modifiers as implementations of the decorator pattern"
    ),
    MyMessage(
        user = 0,
        body = "You can think of Modifiers as implementations of the decorator pattern"
    ),
    MyMessage(
        user = 1,
        body = "You can think of Modifiers as implementations of the decorator pattern"
    ),
    MyMessage(
        user = 0,
        body = "You can think of Modifiers as implementations of the decorator pattern"
    )
)


@Composable
fun MyComponent(message: MyMessage) {
    val backgroundColor = if (message.user == 1) {
        Color.Magenta
    } else {
        Color.Cyan
    }

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(10.dp),
        backgroundColor = backgroundColor

    ) {
        Text(message.body)
    }
}
