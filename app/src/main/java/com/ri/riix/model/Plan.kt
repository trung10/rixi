package com.ri.riix.model

data class Plan(val list: List<Exercise>) {}

data class Exercise(
    var name: String = "",
    var weight: Int,
    var set: Int,
    var rep: Int
) {

}