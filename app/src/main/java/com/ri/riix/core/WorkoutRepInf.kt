package com.ri.riix.core

interface WorkoutRepInf {
    var currentState: String
    var exercise: Exercise?

    fun newState(state: String, isNewRep: () -> Unit)
}

enum class Exercise {
    FlyCable,
    Squad
}