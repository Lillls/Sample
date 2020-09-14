package com.xiaoyu.videoplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.xiaoyu.videoplayer.viewmodel.SourcesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sourceAdapter = SourceAdapter()
        recyclerView.adapter = sourceAdapter
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                applicationContext,
                RecyclerView.VERTICAL
            )
        )
        val vm = ViewModelProvider(this).get(SourcesViewModel::class.java)
        vm.getData().observe(this, Observer {
            sourceAdapter.setData(it)
        })

    }
}
