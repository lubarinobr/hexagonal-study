package com.chrono.whattoeat.domain

data class ProductDTO(
    val id: Long? = null,
    val name: String,
    val unit: Unit? = null
) {

    companion object {
        fun toEntity(productDTO: ProductDTO, id: Long? = null) : Product {
            return Product(
                id = productDTO.id,
                name = productDTO.name,
                unit = productDTO.unit
            )
        }
    }
}
