package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter(
    private val numbersList: List<Int>,
    private var targetPath: String,
    private val context: Context
) :
    RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.number_item, parent, false)
        return NumberViewHolder(view)
    }

    override fun getItemCount(): Int {
        return numbersList.size
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.numberText.text = numbersList[position].toString()
        holder.numberLayout.setBackgroundColor(context.getColor(R.color.white))
        when (targetPath) {
            context.getString(R.string.prime_target_path) -> {
                if (isPrime(numbersList[position])) {
                    holder.numberLayout.setBackgroundColor(context.getColor(R.color.action_prime_bg_color))
                }
            }

            context.getString(R.string.even_target_path) -> {

                if (numbersList[position] % 2 == 0) {
                    holder.numberLayout.setBackgroundColor(context.getColor(R.color.action_even_bg_color))
                }
            }

            context.getString(R.string.odd_target_path) -> {
                if (numbersList[position] % 2 != 0) {
                    holder.numberLayout.setBackgroundColor(context.getColor(R.color.action_odd_bg_color))
                }
            }

            context.getString(R.string.fibonacci_target_path) -> {
                if (isFibonacci(numbersList[position])) {
                    holder.numberLayout.setBackgroundColor(context.getColor(R.color.action_fibonacci_bg_color))
                }
            }
        }

    }

    fun setNumber(targetPathChange: String) {
        targetPath = targetPathChange
        notifyItemRangeChanged(0, numbersList.size)
    }

    private fun isPrime(number: Int): Boolean {
        if (number <= 1) {
            return false
        }
        if (number == 2) {
            return true
        }
        if (number % 2 == 0) {
            return false
        }
        var divisor = 3
        while (divisor * divisor <= number) {
            if (number % divisor == 0) {
                return false
            }
            divisor += 2
        }

        return true
    }

    private fun isFibonacci(number: Int): Boolean {
        if (number < 0) return false

        var a = 0
        var b = 1
        while (a <= number) {
            if (a == number) return true
            val temp = a + b
            a = b
            b = temp
        }
        return false
    }


    inner class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numberLayout: LinearLayout = itemView.findViewById(R.id.number_item)
        val numberText: TextView = itemView.findViewById(R.id.digit)
    }
}