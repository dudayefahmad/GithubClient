package com.ahmaddudayef.mitrais.githubclient.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import com.ahmaddudayef.mitrais.core.base.binding.BaseFragmentBinding
import com.ahmaddudayef.mitrais.core.extensions.loadFromUrl
import com.ahmaddudayef.mitrais.githubclient.R
import com.ahmaddudayef.mitrais.githubclient.databinding.FragmentDetailUserBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailUserFragment : BaseFragmentBinding<FragmentDetailUserBinding>() {

    private lateinit var userName: String
    private lateinit var id: String
    private lateinit var avatarUrl: String
    private val viewModel by viewModels<DetailUserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString("username").toString()
            id = it.getString("id").toString()
            avatarUrl = it.getString("avatarUrl").toString()
        }

    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailUserBinding
        get() = FragmentDetailUserBinding::inflate

    override fun setupView(binding: FragmentDetailUserBinding) {
        setupViewPagerView(binding, userName)
        startObservingData(binding, userName)
    }

    private fun setupViewPagerView(binding: FragmentDetailUserBinding, userName: String) {
        val detailViewPagerAdapter = DetailPagerAdapter(parentFragmentManager, lifecycle)
        detailViewPagerAdapter.userName = userName
        binding.viewPager.adapter = detailViewPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }

    private fun startObservingData(binding: FragmentDetailUserBinding, userName: String) {
        viewModel.getDetailUser(userName).observe(viewLifecycleOwner) {
            val detailUser = it.data
            if (detailUser != null) {
                binding.apply {
                    tvName.text = detailUser.name
                    tvUsername.text = detailUser.login
                    tvFollowers.text = "${detailUser.followers} Followers"
                    tvFollowing.text = "${detailUser.following} Following"
                    ivProfile.loadFromUrl(detailUser.avatar_url)
                }
            }
        }
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.tab_following, R.string.tab_followers)
    }
}