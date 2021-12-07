package com.chrono.whattoeat.foods.domain.ports

import com.chrono.whattoeat.foods.domain.model.Recipe
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
@Transactional
class RecipeService(
    private val recipeRepository: RecipeRepository
) {

    fun create(name: String, ingredients: List<String>): Mono<Recipe> {
        return recipeRepository.create(Recipe(name = name, ingredients = ingredients))
    }

    fun findAll(): Flux<Recipe> {
        return recipeRepository.getAll()
    }

    fun getListWithFoodToTheWeek(): Flux<Recipe> {
        return recipeRepository.getRandomsFoods()
    }
}