package com.rodentia6.sampledatabinding

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rodentia6.sampledatabinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ViewModelオブジェクトを生成する
        val viewModelFactory: ViewModelProvider.Factory = ViewModelProvider.NewInstanceFactory()
        val viewModelProvider = ViewModelProvider(this@MainActivity, viewModelFactory)
        val viewModel: MainViewModel = viewModelProvider.get(MainViewModel::class.java)
        // 上記3行のコードは、build.gradleにimplementation 'android.arch.lifecycle:extensions:1.1.1'を追加すると下記で代替できるようになる
        // val viewModel: MainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        // Bindingオブジェクトを生成する
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        button.setOnClickListener {
            viewModel.toggle()
        }
    }
}
