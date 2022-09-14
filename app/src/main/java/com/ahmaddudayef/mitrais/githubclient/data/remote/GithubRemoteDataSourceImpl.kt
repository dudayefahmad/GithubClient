package com.ahmaddudayef.mitrais.githubclient.data.remote

import com.ahmaddudayef.mitrais.core.network.ApiResponse
import com.ahmaddudayef.mitrais.githubclient.data.remote.model.response.UsersResponse
import com.ahmaddudayef.mitrais.githubclient.data.remote.service.GithubApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GithubRemoteDataSourceImpl @Inject constructor(private val apiService: GithubApiService) :
    GithubRemoteDataSource {

    override fun getListUsers(): Flow<ApiResponse<List<UsersResponse>>> {
        return flow {
            try {
                val response = apiService.getListUsers()
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getSearchUsers(query: String): Flow<ApiResponse<List<UsersResponse>>> {
        return flow {
            try {
                val response = apiService.getSearchUsers(query)
                if (response.items.isNotEmpty()) {
                    emit(ApiResponse.Success(response.items))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getDetailUser(userName: String): Flow<ApiResponse<UsersResponse>> {
        return flow {
            try {
                val response = apiService.getDetailUser(userName)
                if (response != null) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getListFollowers(userName: String): Flow<ApiResponse<List<UsersResponse>>> {
        return flow {
            try {
                val response = apiService.getFollowers(userName)
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getListFollowing(userName: String): Flow<ApiResponse<List<UsersResponse>>> {
        return flow {
            try {
                val response = apiService.getFollowing(userName)
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

}