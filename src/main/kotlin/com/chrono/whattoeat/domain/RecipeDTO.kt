package com.chrono.whattoeat.domain

data class RecipeDTO(
    val id: Long? = null,
    val name: String,
    val products: MutableList<RecipeProductDTO> = mutableListOf()
) {

    companion object {
        fun toEntity(recipeDTO: RecipeDTO, id: Long? = null) : Recipe {
            return Recipe(name = recipeDTO.name)
        }
    }
}

data class RecipeProductDTO(
    val product: ProductDTO,
    val unit: Unit,
    val quantity: Double
)
