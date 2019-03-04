package com.catharsis256.omputus

import android.view.View

data class ButtonKeeper(
        val reset : View,
        val multiplication: View,
        val addition: View,
        val subtraction: View,
        val result: View,
        val numbers: MutableCollection<*>
)