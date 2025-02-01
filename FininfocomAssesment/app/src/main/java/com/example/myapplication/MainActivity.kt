package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var numberAdapter: NumberAdapter
    private val numbersData: MutableList<Int> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        for (i in 1..100) {
            numbersData.add(i)
        }
        val layoutManager = GridLayoutManager(applicationContext, 10)
        binding.numbersGrid.layoutManager = layoutManager
        numberAdapter = NumberAdapter(numbersData, "", applicationContext)
        binding.numbersGrid.adapter = numberAdapter

        val onClickListener: View.OnClickListener = View.OnClickListener { v ->
            when (v?.id) {
                R.id.get_prime_number -> {
                    numberAdapter.setNumber(applicationContext.getString(R.string.prime_target_path))
                }

                R.id.get_even_number -> {
                    numberAdapter.setNumber(applicationContext.getString(R.string.even_target_path))
                }

                R.id.get_odd_numbers -> {
                    numberAdapter.setNumber(applicationContext.getString(R.string.odd_target_path))
                }

                R.id.get_fibonacci_sequence -> {
                    numberAdapter.setNumber(applicationContext.getString(R.string.fibonacci_target_path))
                }

                R.id.remove_filter -> {
                    numberAdapter.setNumber("")
                }
            }
        }
        binding.apply {
            getEvenNumber.setOnClickListener(onClickListener)
            getOddNumbers.setOnClickListener(onClickListener)
            getFibonacciSequence.setOnClickListener(onClickListener)
            getPrimeNumber.setOnClickListener(onClickListener)
            removeFilter.setOnClickListener(onClickListener)
        }
    }


}
