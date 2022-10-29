package com.example.tskmacadders

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.tskmacadders.helper.ProviderHelper
import com.example.tskmacadders.navgation.SetUpNavGraph
import com.example.tskmacadders.ui.theme.TskMacAddersTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TskMacAddersTheme {
                // A surface container using the 'background' color from the theme
                val  navController = rememberNavController()
                SetUpNavGraph(navController)

            }
    }
}


@SuppressLint("SuspiciousIndentation")
@Composable
fun Greeting() {
    val intent = Intent(Intent.ACTION_MAIN, null)
    intent.addCategory(Intent.CATEGORY_LAUNCHER);
    val cn = ComponentName("com.android.settings", "com.android.settings.wifi.WifiSettings")
    intent.setComponent(cn);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    val context = LocalContext.current

    var text by remember {
        mutableStateOf("Home Button")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
          text = ProviderHelper.getMac1()!!
            context.startActivity(intent)


    }) {
            Text(text = text)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Greeting()
}





}

