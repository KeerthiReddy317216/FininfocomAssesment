package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var numberAdapter: NumberAdapter
    private val numbersData:MutableList<Int> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        for (i in 1..100){
            numbersData.add(i)
        }
        val layoutManager:GridLayoutManager = GridLayoutManager(applicationContext,10)
        binding.numbersGrid.layoutManager = layoutManager
        numberAdapter = NumberAdapter(numbersData,"",applicationContext)
        binding.numbersGrid.adapter = numberAdapter

        val onClickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                when(v?.id){
                    R.id.get_prime_number ->{
                        numberAdapter = NumberAdapter(numbersData,applicationContext.resources.getString(R.string.prime_target_path),applicationContext)
                        binding.numbersGrid.adapter = numberAdapter

                    }
                    R.id.get_even_number ->{
                        numberAdapter = NumberAdapter(numbersData,applicationContext.resources.getString(R.string.even_target_path),applicationContext)
                        binding.numbersGrid.adapter = numberAdapter

                    }
                    R.id.get_odd_numbers ->{
                        numberAdapter = NumberAdapter(numbersData,applicationContext.resources.getString(R.string.odd_target_path),applicationContext)
                        binding.numbersGrid.adapter = numberAdapter

                    }
                    R.id.get_fibonacci_sequence ->{
                        numberAdapter = NumberAdapter(numbersData,applicationContext.resources.getString(R.string.fibonacci_target_path),applicationContext)
                        binding.numbersGrid.adapter = numberAdapter

                    }
                    R.id.remove_filter ->{
                        numberAdapter = NumberAdapter(numbersData,"",applicationContext)
                        binding.numbersGrid.adapter = numberAdapter

                    }

                }

            }

        }
        binding.getEvenNumber.setOnClickListener(onClickListener)
        binding.getOddNumbers.setOnClickListener(onClickListener)
        binding.getFibonacciSequence.setOnClickListener(onClickListener)
        binding.getPrimeNumber.setOnClickListener(onClickListener)
        binding.removeFilter.setOnClickListener(onClickListener)
    }



}
