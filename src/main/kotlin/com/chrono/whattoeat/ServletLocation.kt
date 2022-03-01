package com.chrono.whattoeat

import org.springframework.web.servlet.support.ServletUriComponentsBuilder

object ServletLocation {
    fun getUri(id: Long) = ServletUriComponentsBuilder
        .fromCurrentRequestUri()
        .path("/{id}")
        .buildAndExpand(id)
        .toUri()

    fun getCurrentUri() = ServletUriComponentsBuilder
        .fromCurrentRequestUri()
        .build()
        .toUri()
}