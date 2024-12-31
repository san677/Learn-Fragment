package com.example.learnfragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.learnfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var fragamentManager:FragmentManager
    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonFragment1.setOnClickListener {
            gotofragment (Fragment1())
        }
        binding.ButtonFragment2.setOnClickListener {
            gotofragment(Fragment2())
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }


    }
    private fun gotofragment(fragment:Fragment){
        fragamentManager=supportFragmentManager
        fragamentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit()
    }
}