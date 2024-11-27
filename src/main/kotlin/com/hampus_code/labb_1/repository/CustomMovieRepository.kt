package com.hampus_code.labb_1.repository

import com.hampus_code.labb_1.model.CustomMovie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomMovieRepository: JpaRepository<CustomMovie, Long> {
}