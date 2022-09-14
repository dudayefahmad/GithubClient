package com.ahmaddudayef.mitrais.githubclient.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmaddudayef.mitrais.core.base.binding.BaseFragmentBinding
import com.ahmaddudayef.mitrais.core.extensions.showSnackbar
import com.ahmaddudayef.mitrais.core.extensions.toGone
import com.ahmaddudayef.mitrais.core.extensions.toVisible
import com.ahmaddudayef.mitrais.core.presentation.Resource
import com.ahmaddudayef.mitrais.githubclient.databinding.FragmentHomeBinding
import com.ahmaddudayef.mitrais.githubclient.domain.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragmentBinding<FragmentHomeBinding>() {

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var adapter: UserAdapter

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun setupView(binding: FragmentHomeBinding) {
        setupViewHomeFragment(binding)
        startObservingData(binding)
    }

    private fun setupViewHomeFragment(binding: FragmentHomeBinding) {
        adapter = UserAdapter()
        adapter.setOnItemClicCallback(object : UserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailUserFragment(
                    username = data.login,
                    id = data.id.toString(),
                    avatarUrl = data.avatarUrl
                )
                findNavController().navigate(action)
            }
        })
        binding.apply {
            rvUser.layoutManager = LinearLayoutManager(activity)
            rvUser.setHasFixedSize(true)
            rvUser.adapter = adapter
        }

        binding.btnSearch.setOnClickListener {
            searchNews(binding)
        }
    }

    private fun searchNews(binding: FragmentHomeBinding) {
        val query = binding.etQuery.text.toString()
        if (query.isEmpty()) return
        viewModel.searchListUser(query)
    }

    private fun startObservingData(binding: FragmentHomeBinding) {
        viewModel.getListUsers().observe(viewLifecycleOwner) { user ->
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

        viewModel.getSearchUser.observe(viewLifecycleOwner) { user ->
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

    private fun showError(binding: FragmentHomeBinding, message: String?) {
        if (message != null) {
            binding.clRoot.showSnackbar(message)
        }
    }

    private fun setListUserData(data: List<User>?) {
        adapter.setList(data)
    }

    private fun hideLoading(binding: FragmentHomeBinding) {
        binding.progressBar.toGone()
        binding.rvUser.toVisible()
    }

    private fun showLoading(binding: FragmentHomeBinding) {
        binding.progressBar.toVisible()
        binding.rvUser.toGone()
    }
}