package com.americanairlines.a6thkotlintpexec

import android.util.Log

class RestaurantCustomer(private val customerName: String, private val timeToSpend: Int): Runnable {

    private val pricePerMinute =  5

    override fun run() {

        var totalCost = 0
        for(i in 1..timeToSpend){

            Thread.sleep(1000)
            Log.d("TAG_X", "$customerName is being saved.")

            totalCost += pricePerMinute

        }
        Log.d("TAG_X", "$customerName is done. Bill is ${totalCost.convertToDollars()}")

    }

    private fun Int.convertToDollars(): String {
        return "$$this.00"
    }

    private fun Int.cube(): Int {
        return (this * this * this)
    }

}














