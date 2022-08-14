package ru.netology.nmedia.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object AndroidUtils {
    val View.inputMethodManager
        get()= context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    fun hideKeyBoard(view: View) {
        view.inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0, )
    }
    fun ShowKeyboard(view: View) {
        view.inputMethodManager.showSoftInput(view,InputMethodManager.SHOW_IMPLICIT)
    }

}