package com.chrono.whattoeat.foods.adapters.api

import com.chrono.whattoeat.foods.adapters.RecipeRequest
import com.chrono.whattoeat.foods.adapters.RecipeResponse
import com.chrono.whattoeat.foods.domain.model.Recipe
import com.chrono.whattoeat.foods.domain.ports.RecipeService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("recipes")
class RecipeController(
    val recipeFacade: RecipeFacade
) {

    @GetMapping
    fun getAll() : Flux<RecipeResponse> {
        return recipeFacade.getAll()
    }

    @PostMapping
    fun create(@RequestBody recipeRequest: RecipeRequest): Mono<RecipeResponse> {
        return recipeFacade.create(recipeRequest)
    }

    @GetMapping(value = ["/week"])
    fun getRecipesToWeek(): Flux<RecipeResponse> {
        return recipeFacade.getRecipesToWeek()
    }
}