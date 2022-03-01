package com.chrono.whattoeat.service

import com.chrono.whattoeat.domain.Product
import com.chrono.whattoeat.domain.ProductDTO
import com.chrono.whattoeat.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository
) : IProductService {

    override fun findAll(): List<Product> =
        productRepository.findAll()


    override fun findById(id: Long): Product =
        productRepository.findById(id).orElseThrow()

    override fun deleteById(id: Long) {
        productRepository.findById(id)
    }

    override fun create(productDto: ProductDTO) : Long {
        val product = ProductDTO.toEntity(productDto)
        productRepository.save(product)
        return product.id!!
    }

    override fun update(id: Long, productDto: ProductDTO) : ProductDTO {
        val product = ProductDTO.toEntity(productDto, id)
        productRepository.save(product)
        return productDto
    }

    override fun findAllByIds(ids: List<Long?>) : List<ProductDTO> {
        val products = productRepository.findAllById(ids)
        return products.map {
            ProductDTO(it.id, it.name)
        }
    }

    override fun createProducts(products: List<ProductDTO>): List<Product> {
        val productsEntities = products.map {
            ProductDTO.toEntity(it)
        }

        productRepository.saveAll(productsEntities)
        return productsEntities
    }
}