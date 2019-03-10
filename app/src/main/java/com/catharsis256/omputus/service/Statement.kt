package com.catharsis256.omputus.service

import com.catharsis256.omputus.model.Arithmetic

internal class Statement(val value: Double,
                         val sign: Arithmetic? = null) : MathComponent {

    override fun evaluate(): Double =
            sign?.run {
                when(this) {
                    Arithmetic.SQUARE ->  Math.sqrt(value)
                    Arithmetic.SUBTRACTION -> (-value)
                    else -> throw AssertionError("Operation is not supported [${this.name}]")
                }
            }
                    ?: value
}