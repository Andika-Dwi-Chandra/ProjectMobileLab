package com.example.andika_3tia

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.andika_3tia.Home.HomeFragment
import com.example.andika_3tia.Message.MessageFragment
import com.example.andika_3tia.More.MoreFragment
import com.example.andika_3tia.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
//                    Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.message -> {
                    replaceFragment(MessageFragment())
//                    Toast.makeText(this, "Message Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.more -> {
                    replaceFragment(MoreFragment())
//                    Toast.makeText(this, "More Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false // false jika item tidak dikenal
            }
        }
    }
        private fun replaceFragment(fragment: Fragment){
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id,fragment)
                .commit()

    }
}