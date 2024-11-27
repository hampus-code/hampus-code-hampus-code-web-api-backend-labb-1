package com.hampus_code.labb_1.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class CustomMovie(
    val title: String = "",
    val director: String = "",
    val actor: String = "",
    val isEnabled: Boolean = true
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

}