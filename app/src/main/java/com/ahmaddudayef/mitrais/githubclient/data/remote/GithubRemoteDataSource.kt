package com.ahmaddudayef.mitrais.githubclient.data.remote

import com.ahmaddudayef.mitrais.core.network.ApiResponse
import com.ahmaddudayef.mitrais.githubclient.data.remote.model.response.UsersResponse
import kotlinx.coroutines.flow.Flow

interface GithubRemoteDataSource {
    fun getListUsers(): Flow<ApiResponse<List<UsersResponse>>>
    fun getSearchUsers(query: String): Flow<ApiResponse<List<UsersResponse>>>
    fun getDetailUser(userName: String): Flow<ApiResponse<UsersResponse>>
    fun getListFollowers(userName: String): Flow<ApiResponse<List<UsersResponse>>>
    fun getListFollowing(userName: String): Flow<ApiResponse<List<UsersResponse>>>

}