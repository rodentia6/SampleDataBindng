package com.rodentia6.sampledatabinding

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rodentia6.sampledatabinding.databinding.MyActivityBinding
import kotlinx.android.synthetic.main.my_activity.*

class MyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_activity)

        // ViewModelオブジェクトを生成する
        val viewModelFactory: ViewModelProvider.Factory = ViewModelProvider.NewInstanceFactory()
        val viewModelProvider = ViewModelProvider(this@MyActivity, viewModelFactory)
        val viewModel: MyViewModel = viewModelProvider.get(MyViewModel::class.java)
        // 上記3行のコードは、build.gradleにimplementation 'android.arch.lifecycle:extensions:1.1.1'を追加すると下記で代替できるようになる
        // val viewModel: MyViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

        // Bindingオブジェクトを生成する
        val binding: MyActivityBinding = DataBindingUtil.setContentView(this, R.layout.my_activity)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        button.setOnClickListener {
            viewModel.toggle()
        }
    }
}
