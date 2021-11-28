package com.chrono.whattoeat.foods.adapters

import com.chrono.whattoeat.foods.domain.model.Recipe
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.Flow
import java.util.function.Function

data class RecipeResponse(
    val name: String,
    val ingredients: List<String>
) {

    companion object {

        fun of(recipe: Mono<Recipe>) : Mono<RecipeResponse> = recipe.flatMap { Mono.just(RecipeResponse(it.name, it.ingredients)) }

        fun ofList(recipes: Flux<Recipe>) : Flux<RecipeResponse> = recipes.flatMap { Mono.just(RecipeResponse(it.name, it.ingredients)) }
    }
}