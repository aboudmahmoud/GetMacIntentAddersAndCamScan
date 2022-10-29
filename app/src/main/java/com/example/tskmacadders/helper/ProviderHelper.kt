package com.example.tskmacadders.helper

import android.util.Log
import java.net.NetworkInterface
import java.util.*

object ProviderHelper {
    //get the mack adders of Wifi
     fun getMac1(): String? =
        try {
            NetworkInterface.getNetworkInterfaces()
                .toList()
                .find { networkInterface -> networkInterface.name.equals("wlan0", ignoreCase = true) }
                ?.hardwareAddress
                ?.joinToString(separator = ":") { byte -> "%02X".format(byte) }
        } catch (ex: Exception) {
            ex.printStackTrace()
            Log.d("Aboud", "ex: ${ex.message} ")
            null
        }
    fun getMacAddress(): String {
        try {
            val all: List<NetworkInterface> = Collections.list(NetworkInterface.getNetworkInterfaces())
            for (networkInterface in all) {
                if (!networkInterface.name.equals("wlan0", true)) continue
                val macBytes = networkInterface.hardwareAddress ?: return ""
                val res1 = StringBuilder()
                for (b in macBytes) {
                    res1.append(String.format("%02X:", b))
                }
                if (res1.isNotEmpty()) {
                    res1.deleteCharAt(res1.length - 1)
                }
                return res1.toString()
            }
        } catch (ex: java.lang.Exception) {
            Log.e("TAG", "getMacAddress: ", ex)
        }
        return ""
    }

}