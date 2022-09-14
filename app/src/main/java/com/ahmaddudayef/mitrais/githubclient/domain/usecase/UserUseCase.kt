package com.ahmaddudayef.mitrais.githubclient.domain.usecase

import com.ahmaddudayef.mitrais.core.presentation.Resource
import com.ahmaddudayef.mitrais.githubclient.domain.model.DetailUser
import com.ahmaddudayef.mitrais.githubclient.domain.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface UserUseCase {
    fun getListuser(): Flow<Resource<List<User>>>
    fun getSearchUser(query: String): Flow<Resource<List<User>>>
    fun getDetailUser(userName: String): Flow<Resource<DetailUser>>
    fun getListFollowers(userName: String): Flow<Resource<List<User>>>
    fun getListFollowing(userName: String): Flow<Resource<List<User>>>
}