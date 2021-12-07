package com.chrono.whattoeat.foods.adapters.recipedb

import com.chrono.whattoeat.foods.domain.model.Recipe
import com.chrono.whattoeat.foods.domain.ports.RecipeRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Component
@Profile("test")
class LocalRecipeRepository : RecipeRepository {

    private var list = mutableListOf<Recipe>()

    init {
        val recipe1 = Recipe(UUID.randomUUID().toString(), "Cuscuz Com Queijo", ingredients = listOf("cuscuz", "queijo"))
        val recipe2 = Recipe(UUID.randomUUID().toString(), "Misto quente", ingredients = listOf("pão", "manteiga", "presunto", "queijo"))
        val recipe3 = Recipe(UUID.randomUUID().toString(), "Maça", ingredients = listOf("maça"))
        val recipe4 = Recipe(UUID.randomUUID().toString(), "Pêra", ingredients = listOf("pêra"))
        val recipe5 = Recipe(UUID.randomUUID().toString(), "Laranja", ingredients = listOf("laranja"))
        val recipe6 = Recipe(UUID.randomUUID().toString(), "Uva", ingredients = listOf("uva"))
        val recipe7 = Recipe(UUID.randomUUID().toString(), "banana", ingredients = listOf("banana"))
        list = mutableListOf(recipe1, recipe2, recipe3, recipe4, recipe5, recipe6, recipe7)
    }

    override fun create(recipe: Recipe): Mono<Recipe> {
        val newRecipe = Recipe(UUID.randomUUID().toString(), recipe.name, recipe.ingredients)
        list.add(newRecipe)
        return Mono.just(newRecipe)
    }

    override fun getAll(): Flux<Recipe> {
        return Mono.just(list).flatMapIterable { it }
    }

    override fun getRandomsFoods(): Flux<Recipe> {
        return Mono.just(list.shuffled().take(6)).flatMapIterable { it }
    }
}