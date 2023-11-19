package com.ri.riix.core

import com.ri.riix.model.DEVICE_STATE
import com.ri.riix.utils.toState

class WorkoutEngine(override var currentState: String,
                    override var exercise: Exercise? = null) : WorkoutRepInf {

    private var isTurnLeft = false
    private var isTurnRight = false

    private var isFront = false
    private var isBehind = false

    private var isUp = false
    private var isDown = false

    override fun newState(newState: String, isNewRep: () -> Unit) {
        exercise?.let {exc ->
            when(exc) {
                Exercise.FlyCable -> {
                    when (newState)  {
                        DEVICE_STATE.SS_STT_OG.toState() -> {

                        }

                        DEVICE_STATE.SS_ACC_XP.toState() -> {
                            if (isTurnRight)
                                isNewRep.invoke()

                            resetAcc()
                            isTurnLeft = true
                        }

                        DEVICE_STATE.SS_ACC_XN.toState() -> {
                            if (isTurnLeft)
                                isNewRep.invoke()

                            resetAcc()
                            isTurnRight = true
                        }

                        DEVICE_STATE.SS_ACC_YP.toState() -> {
                            if (isBehind)
                                isNewRep.invoke()

                            resetAcc()
                            isFront = true
                        }

                        DEVICE_STATE.SS_ACC_YN.toState() -> {
                            if (isFront)
                                isNewRep.invoke()

                            resetAcc()
                            isBehind = true
                        }

                        DEVICE_STATE.SS_ACC_ZP.toState() -> {

                        }

                        DEVICE_STATE.SS_ACC_ZN.toState() -> {

                        }
                    }

                }

                Exercise.Squad -> {
                    when (currentState)  {
                        DEVICE_STATE.SS_STT_OG.toState() -> {

                        }
                        DEVICE_STATE.SS_ACC_XP.toState() -> {

                        }

                        DEVICE_STATE.SS_ACC_XN.toState() -> {

                        }

                        DEVICE_STATE.SS_ACC_YP.toState() -> {

                        }

                        DEVICE_STATE.SS_ACC_YN.toState() -> {

                        }

                        DEVICE_STATE.SS_ACC_ZP.toState() -> {
                            if (isDown)
                                isNewRep.invoke()

                            resetAcc()
                            isUp = true
                        }

                        DEVICE_STATE.SS_ACC_ZN.toState() -> {
                            if (isUp)
                                isNewRep.invoke()

                            resetAcc()
                            isDown = true
                        }
                    }
                }
            }
            currentState = newState
        }
    }

    private fun resetAcc() {
        isTurnLeft = false
        isTurnRight = false

        isFront = false
        isBehind = false

        isUp = false
        isDown = false
    }
}