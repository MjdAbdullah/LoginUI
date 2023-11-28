package com.example.loginui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginui.ui.theme.LoginUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //new commend
        setContent {
            LoginUITheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        welcomeFaild()
                    }
                }
            }
        }
    }
}

@Composable
fun welcomeFaild() {
    var name = remember {
        mutableStateOf("")
    }
    var userName = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .border(
                width = 4.dp,
                color = Color.Black,
                shape = RoundedCornerShape(5)
            )
            .padding(20.dp)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        OutlinedTextField(
            value = name.value ,
            onValueChange = {name.value = it},
            label = { Text(text = "Name") },
            maxLines = 1
        )
        Button(
            onClick = { userName.value = name.value },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.DarkGray,
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text(text = "LogIn", fontWeight = FontWeight.Bold)
        }
        Image(painter = painterResource(id = R.drawable.jetphoto) , contentDescription = "Logo Image")
        Text(
            text = "Hello ${userName.value} !",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Bast place to write life stories \nand share your journey experiences",
            fontSize = 16.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginUITheme {
        welcomeFaild()
    }
}