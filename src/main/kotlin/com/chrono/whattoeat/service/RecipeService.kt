package com.chrono.whattoeat.service

import com.chrono.whattoeat.domain.Recipe
import com.chrono.whattoeat.domain.RecipeDTO
import com.chrono.whattoeat.repository.RecipeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RecipeService(
    private val recipeRepository: RecipeRepository,
    private val productService: IProductService
) : IRecipeService {

    override fun findAll(): List<Recipe> =
        recipeRepository.findAll()

    override fun findById(id: Long): Recipe =
        recipeRepository.findById(id).orElseThrow()

    override fun deleteById(id: Long) {
        recipeRepository.deleteById(id)
    }

    override fun create(recipeDTO: RecipeDTO) : Long {
        val recipe = RecipeDTO.toEntity(recipeDTO)
        recipeDTO.products.forEach {
            val product = productService.findById(it.product.id!!)
            recipe.addProducts(product, it.unit, it.quantity)
        }
        recipeRepository.save(recipe)
        return recipe.id!!
    }
}