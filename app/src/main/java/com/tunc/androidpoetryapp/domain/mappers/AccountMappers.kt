package com.tunc.androidpoetryapp.domain.mappers

import com.tunc.androidpoetryapp.data.model.response.UserResponse
import com.tunc.androidpoetryapp.domain.entity.User


fun UserResponse.toUser() = User(
    userId = this.id,
    name = this.name,
    surname = this.surname,
    fullName = this.name + " " + this.surname
)
