package com.chrono.whattoeat.foods.adapters.recipedb

import com.chrono.whattoeat.foods.domain.model.Recipe
import com.chrono.whattoeat.foods.domain.ports.RecipeRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
@Profile("!test")
class DbRecipeRepository(
    val iDbRecipeRepository: IDbRecipeRepository
) : RecipeRepository {

    override fun create(recipe: Recipe): Mono<Recipe> {
        return iDbRecipeRepository.save(recipe)
    }

    override fun getAll(): Flux<Recipe> {
        return iDbRecipeRepository.findAll()
    }

    override fun getRandomsFoods(): Flux<Recipe> {
        TODO("Not yet implemented")
    }
}