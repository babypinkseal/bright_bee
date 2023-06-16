package com.example.brightbee.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.brightbee.data.User

class SignUpViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    // TODO: Implement logic to create a new user account and update the LiveData
    fun signUp(name: String, email: String, password: String) {
        // Create a new user account
        val newUser = // TODO: Create a new user account
            _user.value = newUser
    }
}
