package com.americanairlines.a6thkotlintpexec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Toast

class MainActivity : AppCompatActivity(), Handler.Callback {

    private lateinit var handlerUtil: HandlerUtil

    private lateinit var myCard: CustomerCard
    private lateinit var myCard1: CustomerCard
    private lateinit var myCard2: CustomerCard
    private lateinit var handler: Handler

    private lateinit var cust1: RestaurantCustomer
    private lateinit var cust2: RestaurantCustomer
    private lateinit var cust3: RestaurantCustomer

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myCard = findViewById(R.id.myCard1)
        myCard1 = findViewById(R.id.myCard2)
        myCard2 = findViewById(R.id.myCard3)

        myCard.customerName = "Chinkhwangwa, Dalo Chink..."

        myCard.setOnClickListener {
            Toast.makeText(this, myCard.customerName, Toast.LENGTH_SHORT).show()
        }

        handler = Handler(Looper.getMainLooper(), this)

        cust1 = RestaurantCustomer("Dalo", 30, handler)
        cust2 = RestaurantCustomer("Tony", 23, handler)
        cust3 = RestaurantCustomer("John", 29, handler)

        handlerUtil = HandlerUtil(handler, mutableListOf(cust1, cust2, cust3))
        handlerUtil.serveExistingCustomers()

        myCard.customerName = cust1.customerName
        myCard1.customerName = cust2.customerName
        myCard2.customerName = cust3.customerName


    }

    override fun handleMessage(p0: Message): Boolean {

        when(p0.data.getString("user_id")){
            cust1.hashCode().toString() -> {
                myCard.progressLevel = p0.data.getInt("user_prog")
            }
            cust2.hashCode().toString() -> {
                myCard1.progressLevel = p0.data.getInt("user_prog")
            }
            cust3.hashCode().toString() -> {
                myCard2.progressLevel = p0.data.getInt("user_prog")
            }
        }

        return true
    }
}







