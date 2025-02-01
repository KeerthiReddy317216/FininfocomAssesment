package com.example.myapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter(val numbersList:List<Int>, val targetPath: String,val context: Context):
    RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.number_item,parent,false)
        return NumberViewHolder(view)
    }

    override fun getItemCount(): Int {
        return numbersList.size
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.numberText.text = numbersList[position].toString()

        if(targetPath.equals(context.resources.getString(R.string.prime_target_path))){
            if(isPrime(numbersList[position])){
                holder.numberLayout.setBackgroundColor(context.resources.getColor(R.color.action_prime_bg_color))
            }
        } else if(targetPath.equals(context.resources.getString(R.string.even_target_path))){
            if(numbersList[position] % 2 == 0){
                holder.numberLayout.setBackgroundColor(context.resources.getColor(R.color.action_even_bg_color))
            }
        } else if(targetPath.equals(context.resources.getString(R.string.odd_target_path))){
            if(numbersList[position] % 2 != 0){
                holder.numberLayout.setBackgroundColor(context.resources.getColor(R.color.action_odd_bg_color))
            }
        } else if(targetPath.equals(context.resources.getString(R.string.fibonacci_target_path))){
            if(isFibonacci(numbersList[position])){
                holder.numberLayout.setBackgroundColor(context.resources.getColor(R.color.action_fibonacci_bg_color))
            }
        }
    }
    fun isPrime(number: Int): Boolean {
        if (number <= 1) {
            return false  // Numbers less than or equal to 1 are not prime
        }
        if (number == 2) {
            return true  // 2 is a prime number
        }
        if (number % 2 == 0) {
            return false  // Even numbers greater than 2 are not prime
        }

        // Check odd divisors from 3 up to sqrt(number)
        var divisor = 3
        while (divisor * divisor <= number) {
            if (number % divisor == 0) {
                return false  // Found a divisor, not a prime number
            }
            divisor += 2  // Check next odd number
        }

        return true  // No divisors found, it's a prime number
    }
    fun isFibonacci(number: Int): Boolean {
        if (number < 0) return false  // Fibonacci sequence starts from 0

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


    inner class NumberViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
        val numberLayout: LinearLayout = itemView.findViewById(R.id.number_item)
        val numberText: TextView = itemView.findViewById(R.id.digit)
    }
}