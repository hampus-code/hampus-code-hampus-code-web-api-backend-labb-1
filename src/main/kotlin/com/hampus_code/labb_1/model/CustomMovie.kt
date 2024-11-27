package com.hampus_code.labb_1.model

import jakarta.persistence.*

@Entity
@Table(name = "movie")
class CustomMovie(
    var title: String = "",
    var director: String = "",
    var actor: String = "",
    var isEnabled: Boolean = true
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

}