package com.playground.model.Pojo

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("data")
        val data: LoginData,

    @field:SerializedName("message")
        val message: String,

    @field:SerializedName("status")
        val status: Int,

    @field:SerializedName("user_msg")
        val userMsg: String
    )


data class LoginData(

    @field:SerializedName("phone_no")
    val phoneNo: String,

    @field:SerializedName("is_active")
    val isActive: Boolean,

    @field:SerializedName("gender")
    val gender: String,

    @field:SerializedName("created")
    val created: String,

    @field:SerializedName("profile_pic")
    val profilePic: String,

    @field:SerializedName("last_name")
    val lastName: String,

    @field:SerializedName("access_token")
    val accessToken: String,

    @field:SerializedName("role_id")
    val roleId: Int,

    @field:SerializedName("dob")
    val dob: String,

    @field:SerializedName("modified")
    val modified: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("first_name")
    val firstName: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("country_id")
    val countryId: Any,

    @field:SerializedName("username")
    val username: String
)