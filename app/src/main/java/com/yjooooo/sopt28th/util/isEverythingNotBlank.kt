package com.yjooooo.sopt28th.util

import android.text.Editable

fun isEverythingNotBlank(editTextList: List<Editable>): Boolean {
    for (editText in editTextList) {
        if (editText.isBlank()) {
            return false
        }
    }
    return true
}