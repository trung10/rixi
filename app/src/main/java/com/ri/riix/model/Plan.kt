package com.ri.riix.model

data class Plan(
    val list: List<Exercise>,
    var warningTimeBeforeStartOfEachSet: Int = 10,
    var restPeriodBetweenSets: Int = 30,
    var restPeriodsBetweenExercises: Int = 30
) {}

data class Exercise(
    var name: String = "",
    var weight: Int,
    var set: Int,
    var rep: Int
) {

}