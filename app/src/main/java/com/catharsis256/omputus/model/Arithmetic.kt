package com.catharsis256.omputus.model

import com.catharsis256.omputus.R

enum class Arithmetic(override val id: Int): HasID {

    ADDITION(R.id.addition),
    SUBTRACTION(R.id.subtraction),
    MULTIPLICATION(R.id.multiplication),
    DIVISION(R.id.division),
    POWER(R.id.power),
    SQUARE(R.id.square),

}
