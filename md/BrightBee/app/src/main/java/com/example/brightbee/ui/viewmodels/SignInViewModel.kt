package com.example.brightbee.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.brightbee.data.User

class SignInViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    // TODO: Implement logic to authenticate user credentials and update the LiveData
    fun signIn(email: String, password: String) {
        // Authenticate user credentials
        val authenticatedUser = // TODO: Authenticate user credentials
            _user.value = authenticatedUser
    }
}
