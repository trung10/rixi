package com.ri.riix.utils

import java.util.UUID

fun String.toUUID(): UUID = UUID.fromString(this)