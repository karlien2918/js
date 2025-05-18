package com.example.kotlintest.index

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class IndexController {

    @GetMapping
    fun index(): ResponseEntity<String>{
        return ResponseEntity.ok("hi1")
    }
}