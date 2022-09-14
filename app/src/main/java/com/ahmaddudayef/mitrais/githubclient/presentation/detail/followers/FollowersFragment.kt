package com.ahmaddudayef.mitrais.githubclient.presentation.detail.followers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmaddudayef.mitrais.core.base.binding.BaseFragmentBinding
import com.ahmaddudayef.mitrais.core.extensions.showSnackbar
import com.ahmaddudayef.mitrais.core.extensions.toGone
import com.ahmaddudayef.mitrais.core.extensions.toVisible
import com.ahmaddudayef.mitrais.core.presentation.Resource
import com.ahmaddudayef.mitrais.githubclient.databinding.FragmentFollowersBinding
import com.ahmaddudayef.mitrais.githubclient.domain.model.User
import com.ahmaddudayef.mitrais.githubclient.presentation.home.UserAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FollowersFragment : BaseFragmentBinding<FragmentFollowersBinding>() {

    private val viewModel by viewModels<FollowersViewModel>()
    private lateinit var adapter: UserAdapter
    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString(EXTRA_FOLLOWERS)
        }
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFollowersBinding
        get() = FragmentFollowersBinding::inflate

    override fun setupView(binding: FragmentFollowersBinding) {
        setupViewFollowersFragment(binding)
        userName?.let {
            startObservingData(binding, it)
        }
    }

    private fun startObservingData(binding: FragmentFollowersBinding, userName: String) {
        viewModel.getFollowers(userName).observe(viewLifecycleOwner) { user ->
            if (user != null) {
                println("Data masuk = " + user.data)
                when (user) {
                    is Resource.Loading -> {
                        showLoading(binding)
                    }
                    is Resource.Success -> {
                        hideLoading(binding)
                        setListUserData(user.data)
                    }
                    is Resource.Error -> {
                        hideLoading(binding)
                        showError(binding, user.message)
                    }
                }
            }
        }
    }

    private fun setupViewFollowersFragment(binding: FragmentFollowersBinding) {
        adapter = UserAdapter()
        binding.apply {
            rvFollowers.layoutManager = LinearLayoutManager(activity)
            rvFollowers.setHasFixedSize(true)
            rvFollowers.adapter = adapter
        }
    }

    private fun showError(binding: FragmentFollowersBinding, message: String?) {
        if (message != null) {
            binding.clRoot.showSnackbar(message)
        }
    }

    private fun setListUserData(data: List<User>?) {
        adapter.setList(data)
    }

    private fun hideLoading(binding: FragmentFollowersBinding) {
        binding.progressBar.toGone()
        binding.rvFollowers.toVisible()
    }

    private fun showLoading(binding: FragmentFollowersBinding) {
        binding.progressBar.toVisible()
        binding.rvFollowers.toGone()
    }

    companion object {
        const val EXTRA_FOLLOWERS = "extra_followers"
    }


}