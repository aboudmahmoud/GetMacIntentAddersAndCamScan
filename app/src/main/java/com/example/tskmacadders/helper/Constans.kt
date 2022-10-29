package com.example.tskmacadders.helper

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.View


class Constans {

companion object {
    fun setClickToChat(context: Context, toNumber: String) {
        val url = "https://api.whatsapp.com/send?phone=$toNumber"
        try {
            val pm: PackageManager = context.getPackageManager()
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            context.startActivity(i)
        } catch (e: PackageManager.NameNotFoundException) {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }
    fun openlink(context: Context, lik: String) {

        try {
            val pm: PackageManager = context.getPackageManager()
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(lik)
            context.startActivity(i)
        } catch (e: PackageManager.NameNotFoundException) {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(lik)))
        }
    }

}
}