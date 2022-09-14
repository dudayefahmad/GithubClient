package com.ahmaddudayef.mitrais.githubclient.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ahmaddudayef.mitrais.githubclient.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailUserViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {

    fun getDetailUser(userName: String) = userUseCase.getDetailUser(userName).asLiveData()

}