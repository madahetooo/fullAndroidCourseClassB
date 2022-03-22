package com.apps.fullcourseandroidclassb.unittesting


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{

    @Test
    fun `check username is not empty`(){
        val result = RegistrationUtil.validateRegistrationInputs(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password and confirmPassword are not the same`(){
        var result = RegistrationUtil.validateRegistrationInputs(
            "Eslam",
            "123456",
            "65dsrtfs"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password and confirmPassword are the same`(){
        var result = RegistrationUtil.validateRegistrationInputs(
            "Omar",
            "123456",
            "123456"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username is already taken`(){
        val result = RegistrationUtil.validateRegistrationInputs(
            "Amel",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password is empty`(){
        val result = RegistrationUtil.validateRegistrationInputs(
            "Khaled",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password must has at least 2 digits`(){
        var result = RegistrationUtil.validateRegistrationInputs(
            "Chiraz",
            "chiraz3",
            "chiraz3"
        )
        assertThat(result).isFalse()
    }
}