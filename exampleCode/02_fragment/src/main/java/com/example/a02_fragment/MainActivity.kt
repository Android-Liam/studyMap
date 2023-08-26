package com.example.a02_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.a02_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FragmentOne()
        val secondFragment = FragmentTwo()
        val thirdFragment = FragmentThree()

        setCurrentFragment(firstFragment)

        binding.bottomNaviView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.first_item -> setCurrentFragment(firstFragment)
                R.id.second_item -> setCurrentFragment(secondFragment)
                R.id.third_item -> setCurrentFragment(thirdFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(binding.flFragment.id, fragment)
            commit()
        }
}