package com.ahmaddudayef.mitrais.githubclient.presentation.setting

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ahmaddudayef.mitrais.core.base.binding.BaseFragmentBinding
import com.ahmaddudayef.mitrais.githubclient.databinding.FragmentSettingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : BaseFragmentBinding<FragmentSettingBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingBinding
        get() = FragmentSettingBinding::inflate

    override fun setupView(binding: FragmentSettingBinding) {
        TODO("Not yet implemented")
    }
}