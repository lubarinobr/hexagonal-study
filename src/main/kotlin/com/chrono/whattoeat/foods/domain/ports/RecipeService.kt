package com.chrono.whattoeat.foods.domain.ports

import com.chrono.whattoeat.foods.domain.model.Ingredient
import com.chrono.whattoeat.foods.domain.model.Recipe
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class RecipeService(
    private val recipeRepository: RecipeRepository
) {

    fun create(name: String, ingredients: List<String>): Mono<Recipe> {
        return recipeRepository.create(Recipe(name = name, ingredients = ingredients))
    }

    fun findAll(): Flux<Recipe> {
        return recipeRepository.getAll()
    }
}