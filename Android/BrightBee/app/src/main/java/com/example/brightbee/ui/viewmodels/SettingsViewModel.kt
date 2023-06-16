package com.example.brightbee.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.brightbee.data.User

class SettingsViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    // TODO: Implement logic to fetch user data from the repository and update the LiveData
    fun fetchUserData() {
        // Fetch user data from the repository
        val fetchedUser = // TODO: Fetch user data
            _user.value = fetchedUser
    }

    // TODO: Implement logic to update user data in the repository
    fun updateUser(user: User) {
        // Update user data in the repository
        // TODO: Update user data
    }
}
