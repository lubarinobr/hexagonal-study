package com.chrono.whattoeat.foods

import com.chrono.whattoeat.foods.domain.model.Recipe
import reactor.core.publisher.Flux
import java.util.*

object RecipeFixtures {

    fun recipesWeek() = Flux.just(
        Recipe(UUID.randomUUID().toString(), "Test1", listOf()),
        Recipe(UUID.randomUUID().toString(), "Test2", listOf()),
        Recipe(UUID.randomUUID().toString(), "Test3", listOf()),
        Recipe(UUID.randomUUID().toString(), "Test4", listOf()),
        Recipe(UUID.randomUUID().toString(), "Test5", listOf()),
        Recipe(UUID.randomUUID().toString(), "Test6", listOf()),
    )
}