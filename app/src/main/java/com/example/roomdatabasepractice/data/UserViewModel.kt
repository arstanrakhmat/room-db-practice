package com.example.roomdatabasepractice.data

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    val allWords: LiveData<List<User>> = repository.allUsers.asLiveData()

    fun addUser(user: User) = viewModelScope.launch {
        repository.addUser(user)
    }
}

class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}