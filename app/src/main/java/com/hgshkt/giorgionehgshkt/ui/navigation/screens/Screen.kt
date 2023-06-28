package com.hgshkt.giorgionehgshkt.ui.navigation.screens

sealed class Screen(
    val route: String
) {
    fun withParams(params: List<Param>):String {
        var result = "$route?"
        params.forEach {
            result += "${it.type}=${it.value}"
        }
        return result
    }
}

class Param(
    val type: ParamType,
    val value: String
)

enum class ParamType {
    UserId
}