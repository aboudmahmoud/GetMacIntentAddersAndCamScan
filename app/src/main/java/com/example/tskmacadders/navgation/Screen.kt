package com.example.tskmacadders.navgation

sealed class Screen(val route:String)
{
    object Home:Screen(route = "home_screen")
    object Scan:Screen(route = "scan_screen")
}
