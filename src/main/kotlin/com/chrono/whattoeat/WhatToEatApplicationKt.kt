package com.chrono.whattoeat

import com.chrono.whattoeat.foods.adapters.recipedb.IDbRecipeRepository
import com.chrono.whattoeat.foods.domain.model.Ingredient
import com.chrono.whattoeat.foods.domain.model.Recipe
import com.chrono.whattoeat.foods.domain.ports.RecipeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WhatToEatApplication(
	@Autowired
	val recipeRepository: IDbRecipeRepository
) : CommandLineRunner {

	override fun run(vararg args: String?) {
		val findAll = recipeRepository.findAll()
		recipeRepository.deleteAll(findAll)
		val ingredient = listOf("ovo")
		val recipe = Recipe(name = "Teste", ingredients = ingredient)
		/*val result = recipeRepository.save(recipe)
		println(result.block())*/

	}

}

fun main(args: Array<String>) {
	runApplication<WhatToEatApplication>(*args)
}
