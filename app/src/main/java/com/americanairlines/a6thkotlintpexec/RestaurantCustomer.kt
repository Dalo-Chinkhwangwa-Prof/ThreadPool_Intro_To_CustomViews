package com.americanairlines.a6thkotlintpexec

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log

data class RestaurantCustomer(val customerName: String, val timeToSpend: Int, val handler:Handler): Runnable {

    private val pricePerMinute =  5

    override fun run() {

        var totalCost = 0
        for(i in 1..timeToSpend){

            Thread.sleep(1000)
            Log.d("TAG_X", "$customerName is being saved.")

            totalCost += pricePerMinute

            handler.sendMessage(Message().also {
                it.data = Bundle().also { bnd ->
                    bnd.putString("user_id", this.hashCode().toString())
                    bnd.putInt("user_prog", ((i / timeToSpend.toDouble() * 100).toInt()))
                }
            })

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














