package com.americanairlines.a6thkotlintpexec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message

class MainActivity : AppCompatActivity(), Handler.Callback {

    private lateinit var handlerUtil: HandlerUtil

    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restaurantCustomers = listOf<RestaurantCustomer>(
                RestaurantCustomer("Dalo", 5),
                RestaurantCustomer("Tony", 7),
                RestaurantCustomer("John", 12),
                RestaurantCustomer("Amy", 9),
                RestaurantCustomer("Vanessa", 10),
                RestaurantCustomer("George", 5),
                RestaurantCustomer("Adam", 13),
                RestaurantCustomer("Shrey", 6),
                RestaurantCustomer("Raymond", 7),
                RestaurantCustomer("James", 9),
                RestaurantCustomer("Hicham", 14),
                RestaurantCustomer("Kamel", 15)
        )

        handler = Handler(Looper.getMainLooper(), this)
        handlerUtil = HandlerUtil(handler, restaurantCustomers)
        handlerUtil.serveExistingCustomers()
    }

    override fun handleMessage(p0: Message): Boolean {


        return true
    }
}