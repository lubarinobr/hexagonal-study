package com.chrono.whattoeat.resources

import com.chrono.whattoeat.ServletLocation
import com.chrono.whattoeat.domain.Product
import com.chrono.whattoeat.domain.ProductDTO
import com.chrono.whattoeat.service.ProductService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductResource(
    private val productService: ProductService
) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll() : ResponseEntity<List<Product>> {
        return ResponseEntity.ok(productService.findAll())
    }

    @PostMapping
    fun createProduct(@RequestBody productDTO: List<ProductDTO>): ResponseEntity<List<Product>> {
        val products = productService.createProducts(productDTO)
        return ResponseEntity.created(ServletLocation.getCurrentUri()).body(products)
    }
}