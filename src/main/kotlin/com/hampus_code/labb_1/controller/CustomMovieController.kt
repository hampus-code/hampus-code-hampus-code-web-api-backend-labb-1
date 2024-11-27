package com.hampus_code.labb_1.controller

import com.hampus_code.labb_1.model.CustomMovie
import com.hampus_code.labb_1.repository.CustomMovieRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @PutMapping
    fun putMovie(@RequestParam("id") id: Long,
                 @RequestBody customMovie: CustomMovie
    ): ResponseEntity<String> {

        val existingMovieOptional = customMovieRepository.findById(id)

        if (existingMovieOptional.isPresent) {
            val existingMovie = existingMovieOptional.get()

            existingMovie.title = customMovie.title
            existingMovie.director = customMovie.director
            existingMovie.actor = customMovie.actor
            existingMovie.isEnabled = customMovie.isEnabled

            customMovieRepository.save(existingMovie)

            return ResponseEntity.status(200).body("Movie Updated")
        } else {
            return ResponseEntity.status(404).body("Movie Not Found")
        }
    }

    @DeleteMapping
    fun deleteMovie(@RequestParam("id") id: Long): ResponseEntity<String> {

        val foundOptionalMovie = customMovieRepository.findById(id)

        if (foundOptionalMovie.isPresent) {
            customMovieRepository.deleteById(id)
            return ResponseEntity.status(200).body("Movie Deleted")
        } else {
            return ResponseEntity.status(404).body("Movie Not Found")
        }

    }

}