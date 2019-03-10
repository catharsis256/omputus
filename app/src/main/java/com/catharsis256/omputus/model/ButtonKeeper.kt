package com.catharsis256.omputus.model

import android.view.View
import com.catharsis256.omputus.model.Arithmetic
import com.catharsis256.omputus.model.Control

data class ButtonKeeper(
        val numbers: Map<Int, View>,
        val controls: Map<Control, View>,
        val arithmetic: Map<Arithmetic, View>
)