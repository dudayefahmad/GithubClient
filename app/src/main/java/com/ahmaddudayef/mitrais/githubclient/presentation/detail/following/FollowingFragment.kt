package com.ahmaddudayef.mitrais.githubclient.presentation.detail.following

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
import com.ahmaddudayef.mitrais.githubclient.databinding.FragmentFollowingBinding
import com.ahmaddudayef.mitrais.githubclient.domain.model.User
import com.ahmaddudayef.mitrais.githubclient.presentation.home.UserAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FollowingFragment : BaseFragmentBinding<FragmentFollowingBinding>() {

    private val viewModel by viewModels<FollowingViewModel>()
    private lateinit var adapter: UserAdapter
    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString(EXTRA_FOLLOWING)
        }
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFollowingBinding
        get() = FragmentFollowingBinding::inflate

    override fun setupView(binding: FragmentFollowingBinding) {
        setupViewFollowingFragment(binding)
        userName?.let {
            startObservingData(binding, it)
        }
    }

    private fun startObservingData(binding: FragmentFollowingBinding, userName: String) {
        viewModel.getFollowing(userName).observe(viewLifecycleOwner) { user ->
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

    private fun setupViewFollowingFragment(binding: FragmentFollowingBinding) {
        adapter = UserAdapter()
        binding.apply {
            rvFollowing.layoutManager = LinearLayoutManager(activity)
            rvFollowing.setHasFixedSize(true)
            rvFollowing.adapter = adapter
        }
    }

    private fun showError(binding: FragmentFollowingBinding, message: String?) {
        if (message != null) {
            binding.clRoot.showSnackbar(message)
        }
    }

    private fun setListUserData(data: List<User>?) {
        adapter.setList(data)
    }

    private fun hideLoading(binding: FragmentFollowingBinding) {
        binding.progressBar.toGone()
        binding.rvFollowing.toVisible()
    }

    private fun showLoading(binding: FragmentFollowingBinding) {
        binding.progressBar.toVisible()
        binding.rvFollowing.toGone()
    }

    companion object {
        const val EXTRA_FOLLOWING = "extra_following"
    }


}