package com.catharsis256.omputus.service

import android.util.Log
import android.view.View
import android.widget.TextView
import com.catharsis256.omputus.R
import com.catharsis256.omputus.model.*
import kotlin.properties.Delegates

internal class ButtonManager {

    private var keeper: ButtonKeeper by Delegates.notNull()
    private var screen: TextView by Delegates.notNull()

    fun <T : View> init(idToView: (Int) -> T?) {
        keeper = ButtonKeeper(
                findAndStore(numPadIds, idToView),
                findAndStore(controlPad, idToView),
                findAndStore(arithmeticPad, idToView)
        )
        screen = (idToView(R.id.screen) as? TextView)
                ?: throw AssertionError("Screen with ID [${R.id.screen}] has not found")
    }

    fun activate() {
        with(keeper) {
            for ((key, value) in numbers) {
                value.setOnClickListener {
                    screen.text = (screen.text.toString() + key.toString())
                }
            }

            for ((key, value) in arithmetic) {
                value.setOnClickListener {
                    when(key) {
                        Arithmetic.SQUARE -> null
                        Arithmetic.POWER -> null
                        Arithmetic.MULTIPLICATION -> null
                        Arithmetic.DIVISION -> null
                        Arithmetic.SUBTRACTION -> null
                        Arithmetic.ADDITION -> null

                    }
                }
            }
        }
    }


    private fun <T : View> findAndStore(idArray : Array<Int>, idToView: (Int) -> T?): Map<Int, T> {
        val result = mutableMapOf<Int, T>()

        for ((index, value) in idArray.withIndex()) {
            idToView(value)?.let {
                result[index] = it
            }.also {
                Log.v(Constant.LOG_SYSTEM_COMMON, "NumPad Element [$value] had been found")
            }
                    ?: throw AssertionError("View [$value] has not found")
        }

        return HashMap(result)
    }

    private fun <T, K : View> findAndStore(idArray : Array<T>, idToView: (Int) -> K?):  Map<T, K>
            where T : Enum<T>, T : HasID {

        val result = mutableMapOf<T, K>()

        for (value in idArray) {
            idToView(value.id)?.run {
                result[value] = this
            }.also {
                Log.v(Constant.LOG_SYSTEM_COMMON, "Element [${value.id}] had been found by the control [${value.name}]")
            }
                    ?: throw AssertionError("View [${value.name}] has not found")
        }

        return HashMap(result)
    }

    private companion object {
        val numPadIds = arrayOf(
                R.id.button_0,
                R.id.button_1,
                R.id.button_2,
                R.id.button_3,
                R.id.button_4,
                R.id.button_5,
                R.id.button_6,
                R.id.button_7,
                R.id.button_8,
                R.id.button_9
        )

        val controlPad = arrayOf(
                Control.RESET,
                Control.RESULT,
                Control.LBRACKET,
                Control.RBRACKET
        )

        val arithmeticPad = arrayOf(
                Arithmetic.ADDITION,
                Arithmetic.SUBTRACTION,
                Arithmetic.MULTIPLICATION,
                Arithmetic.DIVISION,
                Arithmetic.POWER,
                Arithmetic.SQUARE
        )
    }

}
