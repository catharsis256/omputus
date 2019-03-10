package com.catharsis256.omputus.service

import com.catharsis256.omputus.model.Arithmetic

internal class Expression(val lStatement: Statement,
                          val rStatement: Statement,
                          val sign: Arithmetic): MathComponent {


    override fun evaluate(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}