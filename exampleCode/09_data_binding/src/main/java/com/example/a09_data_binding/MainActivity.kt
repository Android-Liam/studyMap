package com.example.a09_data_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.a09_data_binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val liveUser = MutableLiveData<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            activity = this@MainActivity
            lifecycleOwner = this@MainActivity
        }

        binding.btnOk.setOnClickListener {
            liveUser.value = User(binding.etName.text.toString(), binding.etAge.text.toString().toInt())
        }
    }
}