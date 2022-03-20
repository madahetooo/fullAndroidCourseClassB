package com.apps.fullcourseandroidclassb.unittesting

object RegistrationUtil {
    /*
    username is not empty and password
    username is already taken
    password and confirm password is the same
    password is complex, password must has at lease 2 digits
     */
    private val existingUsers = listOf("Zouhair","Eslam","Amel")
    fun validateRegistrationInputs(
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty()){
            return false
        }
        if (password != confirmPassword){
            return false
        }
        if (username in existingUsers){
            return false
        }
        if (password.count { it.isDigit() }<2){
            return false
        }
        return true
    }
}