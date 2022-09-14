package com.ahmaddudayef.mitrais.githubclient.domain.usecase

import com.ahmaddudayef.mitrais.core.presentation.Resource
import com.ahmaddudayef.mitrais.githubclient.data.repository.IUserRepository
import com.ahmaddudayef.mitrais.githubclient.domain.model.DetailUser
import com.ahmaddudayef.mitrais.githubclient.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserInteractor @Inject constructor(private val iUserRepository: IUserRepository): UserUseCase {

    override fun getListuser(): Flow<Resource<List<User>>> =
        iUserRepository.getListuser()

    override fun getSearchUser(query: String): Flow<Resource<List<User>>> =
        iUserRepository.getSearchUser(query)

    override fun getDetailUser(userName: String): Flow<Resource<DetailUser>> =
        iUserRepository.getDetailUser(userName)

    override fun getListFollowers(userName: String): Flow<Resource<List<User>>> =
        iUserRepository.getListFollowers(userName)

    override fun getListFollowing(userName: String): Flow<Resource<List<User>>> =
        iUserRepository.getListFollowing(userName)
}