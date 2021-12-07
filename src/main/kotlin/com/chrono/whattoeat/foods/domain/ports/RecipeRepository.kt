package com.chrono.whattoeat.foods.domain.ports

import com.chrono.whattoeat.foods.domain.model.Recipe
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface RecipeRepository {

    fun create(recipe: Recipe): Mono<Recipe>
    fun getAll(): Flux<Recipe>
    fun getRandomsFoods(): Flux<Recipe>
}
