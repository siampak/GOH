package com.example.goh.dataClass


import com.google.gson.annotations.SerializedName

data class ExplorePeople(
    @SerializedName("count")
    var count: Int?,
    @SerializedName("next")
    var next: String?,
    @SerializedName("previous")
    var previous: Any?,
    @SerializedName("results")
    var results: List<PeopleResult?>?
)
data class PeopleResult(
    @SerializedName("dp")
    var dp: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("first_name")
    var firstName: String?,
    @SerializedName("friend_status")
    var friendStatus: String?,
    @SerializedName("full_name")
    var fullName: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("last_name")
    var lastName: String?,
    @SerializedName("username")
    var username: String?
)