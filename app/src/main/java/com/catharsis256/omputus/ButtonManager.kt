package com.catharsis256.omputus

import android.util.Log
import android.view.View
import kotlin.properties.Delegates

internal class ButtonManager {

    private var keeper: ButtonKeeper by Delegates.notNull()

    fun init(idToView: (Int) -> View?) {
        keeper = initKeeper(idToView)
    }

/*
    fun init(backingFieldInit: (Int) -> View): Boolean {
        return if (keeper != null)
            true
        else
            try {
                val numPad = mapOf(
                        0 to backingFieldInit(R.id.button_0),
                        1 to backingFieldInit(R.id.button_1),
                        2 to backingFieldInit(R.id.button_2),
                        3 to backingFieldInit(R.id.button_3),
                        4 to backingFieldInit(R.id.button_4),
                        5 to backingFieldInit(R.id.button_5),
                        6 to backingFieldInit(R.id.button_6),
                        7 to backingFieldInit(R.id.button_7),
                        8 to backingFieldInit(R.id.button_8),
                        9 to backingFieldInit(R.id.button_9)
                )

                val controlPad = mapOf(
                        Control.RESULT to backingFieldInit(R.id.result),
                        Control.RESET to backingFieldInit(R.id.reset)
                )

                val arithmeticPad = mapOf(
                        Arithmetic.ADD to backingFieldInit(R.id.add),
                        Arithmetic.SUBTRACTION to backingFieldInit(R.id.subtraction),
                        Arithmetic.MULTIPLICATION to backingFieldInit(R.id.multiplication),
                        Arithmetic.DIVISION to backingFieldInit(R.id.division)
                )

                keeper = ButtonKeeper(
                        numPad,
                        controlPad,
                        arithmeticPad
                )
                true
            } catch (e : AssertionError) {
                Log.e(Constant.LOG_KERNEL_ERROR, "Some control structures are impossible to initiate", e)
                false
            }
    }
*/

    private fun initKeeper(idToView: (Int) -> View?) =
            ButtonKeeper(
                    findAndStore(numPadIds, idToView),
                    findAndStore(controlPad, idToView),
                    findAndStore(arithmeticPad, idToView)
            )

//            0 to backingFieldInit(R.id.button_0),
//            1 to backingFieldInit(R.id.button_1),
//            2 to backingFieldInit(R.id.button_2),
//            3 to backingFieldInit(R.id.button_3),
//            4 to backingFieldInit(R.id.button_4),
//            5 to backingFieldInit(R.id.button_5),
//            6 to backingFieldInit(R.id.button_6),
//            7 to backingFieldInit(R.id.button_7),
//            8 to backingFieldInit(R.id.button_8),
//            9 to backingFieldInit(R.id.button_9)
//    )

    private fun findAndStore(idArray : Array<Int>, idToView: (Int) -> View?): Map<Int, View> {
        val result = mutableMapOf<Int, View>()

        for ((index, value) in idArray.withIndex()) {
            idToView(value)?.let {
                result[index] = it
                Log.v(Constant.LOG_SYSTEM_COMMON, "NumPad Element [$value] had been found")
            }
                    ?: throw AssertionError("View [$value] has not found")
        }

        return HashMap(result)
    }

    private fun <T> findAndStore(idArray : Array<T>, idToView: (Int) -> View?):  Map<T, View>
            where T : Enum<T>, T : HasID {

        val result = mutableMapOf<T, View>()

        for (value in idArray) {
            idToView(value.id)?.run {
                result[value] = this
            }
                    ?: throw AssertionError("View [$value] has not found")
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
                Control.RESULT
        )

        val arithmeticPad = arrayOf(
                Arithmetic.ADD,
                Arithmetic.SUBTRACTION,
                Arithmetic.MULTIPLICATION,
                Arithmetic.DIVISION
        )
    }

}
