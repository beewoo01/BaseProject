package com.codebros.kbaseproject.screen.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.Job

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding> : Fragment() {

    abstract val viewModel : VM

    protected lateinit var binding : VB

    private lateinit var fetchJob : Job

    abstract fun getViewBinding() : VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initState()
    }

    abstract fun observeData()

    open fun initViews() = Unit

    open fun initState() {
        arguments?.let {
            viewModel.storeState(it)

        }
        initViews()
        fetchJob = viewModel.fetchData()
        observeData()
    }


}