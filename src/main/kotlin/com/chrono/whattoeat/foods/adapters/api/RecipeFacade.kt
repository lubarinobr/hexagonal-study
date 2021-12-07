package com.chrono.whattoeat.foods.adapters.api

import com.chrono.whattoeat.foods.adapters.RecipeRequest
import com.chrono.whattoeat.foods.adapters.RecipeResponse
import com.chrono.whattoeat.foods.domain.ports.RecipeService
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class RecipeFacade(
    private val recipeService: RecipeService
) {

    fun create(recipeRequest: RecipeRequest) : Mono<RecipeResponse> {
        val recipe = recipeService.create(recipeRequest.name, recipeRequest.ingredients)
        return RecipeResponse.of(recipe)
    }

    fun getAll(): Flux<RecipeResponse> {
        return RecipeResponse.ofList(recipeService.findAll())
    }

    fun getRecipesToWeek(): Flux<RecipeResponse> {
        return RecipeResponse.ofList(recipeService.getListWithFoodToTheWeek())
    }
}