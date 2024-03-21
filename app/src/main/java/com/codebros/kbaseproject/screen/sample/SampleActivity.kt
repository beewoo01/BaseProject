package com.codebros.kbaseproject.screen.sample

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.codebros.kbaseproject.R
import com.codebros.kbaseproject.databinding.ActivitySampleBinding
import com.codebros.kbaseproject.model.sample.SamplePhoto
import com.codebros.kbaseproject.screen.base.BaseActivity
import com.codebros.kbaseproject.util.provider.DefaultCustomResourcesProvider
import com.codebros.kbaseproject.widget.adapter.ModelRecyclerAdapter
import com.codebros.kbaseproject.widget.adapter.listener.sample.SampleListener

class SampleActivity :
    BaseActivity<SampleViewModel, ActivitySampleBinding>() {

    override fun getViewBinding(): ActivitySampleBinding =
        ActivitySampleBinding.inflate(layoutInflater)

    override val viewModel: SampleViewModel by viewModels()

    private val resourcesProvider: DefaultCustomResourcesProvider by lazy {
        DefaultCustomResourcesProvider(this@SampleActivity)
    }

    private val adapter by lazy {
        ModelRecyclerAdapter<SamplePhoto, SampleViewModel>(
            listOf(),
            viewModel,
            resourcesProvider,
            adapterListener = object : SampleListener {
                override fun onClickItem(model: SamplePhoto) {
                    Log.wtf("adapter Click title", model.title)
                }

            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.wtf("SampleActivity", "onCreate")
        viewModel.postPhotos()
    }

    override fun initViews() = with(binding){
        Log.wtf("SampleActivity", "initViews")
        sampleRe.adapter = adapter
        /*sampleRe.apply {
            layoutManager = LinearLayoutManager(this@SampleActivity)
            adapter = adapter
        }*/
    }


    override fun observeData() = viewModel.photos.observe(this@SampleActivity) {
        //Update UI
        Log.wtf("SampleActivity", "observeData")
        adapter.submitList(it?.toMutableList())
        //Log.wtf("observeData", it.toString())

    }


}