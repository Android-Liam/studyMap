package com.example.a08_veiwpager2_and_bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.example.a08_veiwpager2_and_bottomnavigation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Connect adapter to pager
        binding.pager.adapter = ViewPagerAdapter(this)

        // When the page changes by sliding, the bottom navigation tab is also activated to that page.
        binding.pager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNavigationView.menu.getItem(position).isChecked = true
                }
            }
        )

        // Connect Listener
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_one -> {
                // Assign the first screen to the current item of ViewPager
                binding.pager.currentItem = 0
                return true
            }
            R.id.item_two -> {
                // Assign the second screen to the current item of ViewPager
                binding.pager.currentItem = 1
                return true
            }
            R.id.item_three -> {
                // Assign the third screen to the current item of ViewPager
                binding.pager.currentItem = 2
                return true
            }
            else -> {
                return false
            }
        }
    }
}