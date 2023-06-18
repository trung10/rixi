package com.ri.riix.model



object Data {
    val UUID_SERVICE_DEVICE = "4fafc201-1fb5-459e-8fcc-c5c9c331914b"
    val UUID_MSG_CHARACTERISTIC = "beb5483e-36e1-4688-b7f5-ea07361b26a8"

    val sample: Plan = Plan(
        list = listOf(
            Workout("Cable fly", 10, 2, 3),
            Workout("Squad", 20, 2, 3)
        )
    )
}

enum class COMMAND {
    SS_SET_CAL,
    SS_DEV_OK,
    SS_GET_STA
}

enum class DEVICE_STATE {
    SS_STT_OG,
    SS_RRT_XP,
    SS_RRT_XN,
    SS_RRT_YP,
    SS_RRT_YN,
    SS_ACC_XP,
    SS_ACC_XN,
    SS_ACC_YP,
    SS_ACC_YN,
    SS_ACC_ZP,
    SS_ACC_ZN
}
