package com.chrono.whattoeat.service

import com.chrono.whattoeat.domain.Product
import com.chrono.whattoeat.domain.ProductDTO
import org.springframework.transaction.annotation.Transactional

interface IProductService : IAbstractService<Product> {
    @Transactional(readOnly = false)
    fun update(id: Long, productDto: ProductDTO): ProductDTO
    @Transactional(readOnly = false)
    fun create(productDto: ProductDTO): Long
    fun findAllByIds(ids: List<Long?>): List<ProductDTO>
    fun createProducts(products: List<ProductDTO>): List<Product>
}
