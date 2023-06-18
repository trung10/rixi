package com.ri.riix.model

data class Plan(
    val list: List<Workout>,
    var warningTimeBeforeStartOfEachSet: Int = 10,
    var restPeriodBetweenSets: Int = 10,
    var restPeriodsBetweenExercises: Int = 10
) {}

data class Workout(
    var name: String = "",
    var weight: Int,
    var set: Int,
    var rep: Int
) {

}