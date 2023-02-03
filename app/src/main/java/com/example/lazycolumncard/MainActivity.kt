package com.example.lazycolumncard

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
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    //val scaffoldState = rememberScaffoldState()

    Scaffold(
        //scaffoldState = scaffoldState,
        topBar = { "Nombre Apellido" } // Top App Bar
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyColumnCardTheme {
        ScaffoldScreen()
    }
}
