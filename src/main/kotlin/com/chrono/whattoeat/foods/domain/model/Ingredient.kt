package com.chrono.whattoeat.foods.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Ingredient(
    val name: String
) {
    @Id
    val id: String = UUID.randomUUID().toString()
}
