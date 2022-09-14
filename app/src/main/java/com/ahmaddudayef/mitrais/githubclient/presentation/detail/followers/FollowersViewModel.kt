package com.ahmaddudayef.mitrais.githubclient.presentation.detail.followers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ahmaddudayef.mitrais.githubclient.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FollowersViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {

    fun getFollowers(userName: String) = userUseCase.getListFollowers(userName).asLiveData()
}