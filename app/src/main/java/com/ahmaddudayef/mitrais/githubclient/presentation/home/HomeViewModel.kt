package com.ahmaddudayef.mitrais.githubclient.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ahmaddudayef.mitrais.githubclient.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {

    private val _searchUser = MutableLiveData<String>()

    fun searchListUser(query: String) {
        _searchUser.value = query
    }

    val getSearchUser = Transformations.switchMap(_searchUser) {
        userUseCase.getSearchUser(it).asLiveData()
    }

    fun getListUsers() = userUseCase.getListuser().asLiveData()

}