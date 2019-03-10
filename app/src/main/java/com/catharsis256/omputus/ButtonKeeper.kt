package com.catharsis256.omputus

import android.view.View

data class ButtonKeeper(
        val numbers: Map<Int, View>,
        val controls: Map<Control, View>,
        val arithmetic: Map<Arithmetic, View>
)