package com.hampus_code.labb_1.controller

import com.hampus_code.labb_1.model.CustomMovie
import com.hampus_code.labb_1.repository.CustomMovieRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movie")
class CustomMovieController(
    private val customMovieRepository: CustomMovieRepository
) {
    
    @GetMapping
    fun getMovieById(@RequestParam("id") id: Long): ResponseEntity<CustomMovie> {

        val foundOptionalMovie = customMovieRepository.findById(id)

        if (foundOptionalMovie.isPresent) {
            val notOptionalMovie = foundOptionalMovie.get()
            return ResponseEntity.status(200).body(notOptionalMovie)
        }

        return ResponseEntity.notFound().build()
    }

    @PostMapping
    fun postNewMovie(@RequestBody customMovie: CustomMovie): ResponseEntity<String> {

        customMovieRepository.save(customMovie)

        return ResponseEntity.status(201).body("Movie Created")
    }
}