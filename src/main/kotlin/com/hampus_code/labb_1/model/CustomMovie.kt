package com.hampus_code.labb_1.model

import jakarta.persistence.*

@Entity
@Table(name = "movie")
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