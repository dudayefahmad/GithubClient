package com.ahmaddudayef.mitrais.githubclient.presentation.detail.following

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ahmaddudayef.mitrais.githubclient.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FollowingViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {

    fun getFollowing(userName: String) = userUseCase.getListFollowing(userName).asLiveData()
}