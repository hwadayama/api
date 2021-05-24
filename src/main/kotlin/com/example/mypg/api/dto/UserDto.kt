package com.example.mypg.api.dto

import java.time.LocalDateTime

data class UserDto(
    val userid: String,
    val name: String,
    val password: String,
    val mailaddress: String?,
    val zipcode: String?,
    val address1: String?,
    val address2: String?,
    val address3: String?,
    val telno: String?,
    val authority: String?,
    val insdate: LocalDateTime,
    val upddate: LocalDateTime
)
