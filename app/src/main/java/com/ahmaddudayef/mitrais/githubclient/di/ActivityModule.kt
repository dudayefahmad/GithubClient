package com.ahmaddudayef.mitrais.githubclient.di

import com.ahmaddudayef.mitrais.githubclient.data.remote.GithubRemoteDataSource
import com.ahmaddudayef.mitrais.githubclient.data.remote.GithubRemoteDataSourceImpl
import com.ahmaddudayef.mitrais.githubclient.data.remote.service.GithubApiService
import com.ahmaddudayef.mitrais.githubclient.data.repository.IUserRepository
import com.ahmaddudayef.mitrais.githubclient.data.repository.UserRepository
import com.ahmaddudayef.mitrais.githubclient.domain.usecase.UserInteractor
import com.ahmaddudayef.mitrais.githubclient.domain.usecase.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ActivityModule {

    @Provides
    fun provideGithubRemoteDataSource(apiService: GithubApiService): GithubRemoteDataSource {
        return GithubRemoteDataSourceImpl(apiService)
    }

    @Provides
    fun provideUserRepository(
        remoteDataSource: GithubRemoteDataSource
    ): IUserRepository {
        return UserRepository(remoteDataSource)
    }

    @Provides
    fun provideUserUseCase(
        userRepository: IUserRepository
    ): UserUseCase {
        return UserInteractor(userRepository)
    }
}