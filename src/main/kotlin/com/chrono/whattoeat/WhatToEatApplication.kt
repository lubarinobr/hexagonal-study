package com.chrono.whattoeat

import com.chrono.whattoeat.domain.ProductDTO
import com.chrono.whattoeat.domain.RecipeDTO
import com.chrono.whattoeat.repository.ProductRepository
import com.chrono.whattoeat.service.IProductService
import com.chrono.whattoeat.service.IRecipeService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.Transactional

@SpringBootApplication
class WhatToEatApplication(
	private val productRepository: ProductRepository,
	private val productService: IProductService,
	private val recipeService: IRecipeService
) : CommandLineRunner {

	override fun run(vararg args: String?) {

	}

}

fun main(args: Array<String>) {
	runApplication<WhatToEatApplication>(*args)
}
