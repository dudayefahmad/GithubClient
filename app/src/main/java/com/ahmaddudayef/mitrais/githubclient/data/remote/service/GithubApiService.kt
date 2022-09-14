package com.ahmaddudayef.mitrais.githubclient.data.remote.service

import com.ahmaddudayef.mitrais.githubclient.data.remote.model.response.UsersResponse
import com.ahmaddudayef.mitrais.githubclient.data.remote.model.response.SearchUsersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApiService {

    @GET("users")
    suspend fun getListUsers(): List<UsersResponse>

    @GET("/search/users")
    suspend fun getSearchUsers(
        @Query("q") query: String
    ): SearchUsersResponse

    @GET("/users/{username}")
    suspend fun getDetailUser(
        @Path("username") username: String
    ): UsersResponse

    @GET("/users/{username}/followers")
    suspend fun getFollowers(
        @Path("username") username: String
    ): ArrayList<UsersResponse>

    @GET("/users/{username}/following")
    suspend fun getFollowing(
        @Path("username") username: String
    ): ArrayList<UsersResponse>

}