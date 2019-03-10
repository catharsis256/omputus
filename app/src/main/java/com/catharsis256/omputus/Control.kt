package com.catharsis256.omputus

enum class Control(override val id: Int): HasID {

    RESET(R.id.reset),
    RESULT(R.id.result),
    LBRACKET(R.id.left_bracket),
    RBRACKET(R.id.right_bracket),

}