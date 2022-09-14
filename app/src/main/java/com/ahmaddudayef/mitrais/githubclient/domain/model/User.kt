package com.ahmaddudayef.mitrais.githubclient.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val avatarUrl: String = "",
    val id: Int = 0,
    val login: String = ""
) : Parcelable