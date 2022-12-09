package com.ixigo.design.sdk

import android.content.Context
import android.widget.Toast

fun String.toToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}