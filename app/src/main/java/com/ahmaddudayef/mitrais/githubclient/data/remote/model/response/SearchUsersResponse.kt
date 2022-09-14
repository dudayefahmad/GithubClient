package com.ahmaddudayef.mitrais.githubclient.data.remote.model.response

data class SearchUsersResponse(
    val incomplete_results: Boolean = false,
    val items: List<UsersResponse> = listOf(),
    val total_count: Int = 0
)