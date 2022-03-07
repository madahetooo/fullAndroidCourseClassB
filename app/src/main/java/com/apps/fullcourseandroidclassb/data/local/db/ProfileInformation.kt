package com.apps.fullcourseandroidclassb.data.local.db

data class ProfileInformation(
    var fullName:String ="",
    var userName:String ="",
    var emailAddress:String ="",
    var phoneNumber:Int =0,
    var password:String ="",
) {
}