package com.example.tskmacadders.screens

import android.content.ComponentName
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.example.tskmacadders.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.tskmacadders.helper.Constans
import com.example.tskmacadders.helper.ProviderHelper
import com.example.tskmacadders.navgation.Screen

@Composable
fun HomeScreen(
    navContoler: NavHostController
) {
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
          //  context.startActivity(intent)


        }) {
            Text(text = text)
        }
        
        IconButton(onClick = { Constans.setClickToChat(context,"9647501990990") }) {
            Icon(painter = painterResource(id = R.drawable.whastap), contentDescription ="whaspImage",
            tint = Color.Unspecified)
        }

        Button(onClick = {

           context.startActivity(intent)


        }) {
            Text(text = "Open Wifi Connect")
        }

        Button(onClick = {

            navContoler.navigate(Screen.Scan.route)


        }) {
            Text(text = "Scan Wifi ")
        }
    }
}

