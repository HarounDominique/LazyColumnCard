package com.example.lazycolumncard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        MyLazyColumn(Modifier.padding(it))
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
fun MyLazyColumn(modifier: Modifier = Modifier) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        // state = rememberLazyListState(),  //
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
    val conditionalBackgroundColor = if (message.user == 0) {
        Color.Yellow
    } else {
        Color.LightGray
    }

    val conditionalhorizontalAlignment = if (message.user == 0) Start else End

    val conditionalCornerShapetopStart = if (message.user == 0) 20.dp else 20.dp
    val conditionalCornerShapetopEnd = if (message.user == 0) 20.dp else 20.dp
    val conditionalCornerShapebottomEnd = if (message.user == 0) 20.dp else 0.dp
    val conditionalCornerShapebottomStart = if (message.user == 0) 0.dp else 20.dp

    Column(modifier = Modifier.fillMaxWidth().background(Color.Black)) {
        Card(
            shape = RoundedCornerShape(
                topStart = conditionalCornerShapetopStart,
                topEnd = conditionalCornerShapetopEnd,
                bottomEnd = conditionalCornerShapebottomEnd,
                bottomStart = conditionalCornerShapebottomStart,
            ),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(.9f)
                .align(conditionalhorizontalAlignment),
            backgroundColor = conditionalBackgroundColor

        ) {
            Text(
                message.body,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            )
        }

    }
}
