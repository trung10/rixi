package com.ri.riix.model



object Data {
    val UUID_SERVICE_DEVICE = "4FAFC201-1FB5-459-8FCC-C5C9C331914B"
    val UUID_MSG_CHARACTERISTIC = "BEB5483E-361-4688-B7F5-EA07361B26A8"

    val sample: Plan = Plan(
        list = listOf(
            Exercise("Cable fly", 10, 3, 10),
            Exercise("Squad", 20, 3, 10)
        )
    )
}