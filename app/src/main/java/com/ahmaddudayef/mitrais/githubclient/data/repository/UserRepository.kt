package com.ahmaddudayef.mitrais.githubclient.data.repository

import com.ahmaddudayef.mitrais.core.network.ApiResponse
import com.ahmaddudayef.mitrais.core.presentation.Resource
import com.ahmaddudayef.mitrais.githubclient.data.DataMapper
import com.ahmaddudayef.mitrais.githubclient.data.remote.GithubRemoteDataSource
import com.ahmaddudayef.mitrais.githubclient.domain.model.DetailUser
import com.ahmaddudayef.mitrais.githubclient.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remoteDataSource: GithubRemoteDataSource
) : IUserRepository {

    override fun getListuser(): Flow<Resource<List<User>>> =
        flow {
            emit(Resource.Loading())
            when (val listUserResponse = remoteDataSource.getListUsers().first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(listUserResponse.data.map {
                        DataMapper.mapListUserResponseToUserDomain(it)
                    }))
                }
                is ApiResponse.Empty -> {
                    emit(Resource.Success(listOf()))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(listUserResponse.errorMessage))
                }
            }
        }

    override fun getSearchUser(query: String): Flow<Resource<List<User>>> =
        flow {
            emit(Resource.Loading())
            when (val listUserResponse = remoteDataSource.getSearchUsers(query).first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(listUserResponse.data.map {
                        DataMapper.mapListUserResponseToUserDomain(it)
                    }))
                }
                is ApiResponse.Empty -> {
                    emit(Resource.Success(listOf()))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(listUserResponse.errorMessage))
                }
            }
        }

    override fun getDetailUser(userName: String): Flow<Resource<DetailUser>> =
        flow {
            emit(Resource.Loading())
            when (val detailUserResponse = remoteDataSource.getDetailUser(userName).first()) {
                is ApiResponse.Success -> {
                    val detailMovieMapper = DataMapper.mapDetailUserResponseToDetailUserDomain(detailUserResponse.data)
                    emit(Resource.Success(detailMovieMapper))
                }
                is ApiResponse.Empty -> {
                    emit(Resource.Success(null))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(detailUserResponse.errorMessage))
                }
            }
        }

    override fun getListFollowers(userName: String): Flow<Resource<List<User>>> =
        flow {
            emit(Resource.Loading())
            when (val listUserResponse = remoteDataSource.getListFollowers(userName).first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(listUserResponse.data.map {
                        DataMapper.mapListUserResponseToUserDomain(it)
                    }))
                }
                is ApiResponse.Empty -> {
                    emit(Resource.Success(listOf()))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(listUserResponse.errorMessage))
                }
            }
        }

    override fun getListFollowing(userName: String): Flow<Resource<List<User>>> =
        flow {
            emit(Resource.Loading())
            when (val listUserResponse = remoteDataSource.getListFollowing(userName).first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(listUserResponse.data.map {
                        DataMapper.mapListUserResponseToUserDomain(it)
                    }))
                }
                is ApiResponse.Empty -> {
                    emit(Resource.Success(listOf()))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(listUserResponse.errorMessage))
                }
            }
        }


}