package com.ahmaddudayef.mitrais.githubclient.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ahmaddudayef.mitrais.githubclient.presentation.detail.followers.FollowersFragment
import com.ahmaddudayef.mitrais.githubclient.presentation.detail.followers.FollowersFragment.Companion.EXTRA_FOLLOWERS
import com.ahmaddudayef.mitrais.githubclient.presentation.detail.following.FollowingFragment
import com.ahmaddudayef.mitrais.githubclient.presentation.detail.following.FollowingFragment.Companion.EXTRA_FOLLOWING

class DetailPagerAdapter(fragmentManager: FragmentManager, lifeCycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifeCycle) {

    lateinit var userName: String

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = FollowingFragment()
                fragment.arguments = Bundle().apply {
                    putString(EXTRA_FOLLOWING, userName)
                }
            }
            1 -> {
                fragment = FollowersFragment()
                fragment.arguments = Bundle().apply {
                    putString(EXTRA_FOLLOWERS, userName)
                }
            }
        }
        return fragment as Fragment
    }

}