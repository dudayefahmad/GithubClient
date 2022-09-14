package com.ahmaddudayef.mitrais.githubclient.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailUser (
    val name: String,
    val login: String,
    val followers: String,
    val following: String,
    val avatar_url: String
): Parcelable