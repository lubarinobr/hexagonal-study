package com.chrono.whattoeat.domain

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.STRING)
enum class Unit(name: String) {
    KG("KG"),
    M("M"),
    L("L"),
    CL("CL"),
    ML("ML"),
    G("G"),
    MG("MG"),
    CHA("CHA"),
    COLHERES_SOPA("COLHERES (SOPA)"),
    UN("UN")

}