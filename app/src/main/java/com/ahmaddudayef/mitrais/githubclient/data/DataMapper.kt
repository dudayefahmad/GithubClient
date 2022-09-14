package com.ahmaddudayef.mitrais.githubclient.data

import com.ahmaddudayef.mitrais.githubclient.data.remote.model.response.UsersResponse
import com.ahmaddudayef.mitrais.githubclient.domain.model.DetailUser
import com.ahmaddudayef.mitrais.githubclient.domain.model.User

object DataMapper {

    fun mapListUserResponseToUserDomain(userResponse: UsersResponse): User {
        return User(
            avatarUrl = userResponse.avatar_url ?: "",
            id = userResponse.id ?: 0,
            login = userResponse.login ?: ""
        )
    }

    fun mapDetailUserResponseToDetailUserDomain(usersResponse: UsersResponse): DetailUser {
        return DetailUser(
            name = usersResponse.name ?: "",
            login = usersResponse.login ?: "",
            followers = usersResponse.followers.toString() ?: "",
            following = usersResponse.following.toString() ?: "",
            avatar_url = usersResponse.avatar_url ?: ""
        )
    }


}