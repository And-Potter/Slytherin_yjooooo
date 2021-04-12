package com.yjooooo.sopt28th.util

import android.content.Context
import android.widget.Toast

fun ToastMessageUtil(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}