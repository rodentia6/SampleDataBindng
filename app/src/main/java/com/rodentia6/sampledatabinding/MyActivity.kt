package com.rodentia6.sampledatabinding

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rodentia6.sampledatabinding.databinding.MyActivityBinding
import kotlinx.android.synthetic.main.my_activity.*

class MyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_activity)

        val viewModel: MyViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        val binding: MyActivityBinding = DataBindingUtil.setContentView(this, R.layout.my_activity)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        button.setOnClickListener {
            viewModel.toggle()
        }
    }
}
