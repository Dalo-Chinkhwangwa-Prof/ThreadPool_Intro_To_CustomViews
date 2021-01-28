package com.americanairlines.a6thkotlintpexec

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView

@SuppressLint("Recycle")
class CustomerCard(context: Context, val attributeSet: AttributeSet): CardView(context, attributeSet) {

    private lateinit var customerNameText: TextView
    private lateinit var serviceProgress: ProgressBar

    var customerName: String
    get() = customerNameText.text.toString()
    set(value){
        customerNameText.text = value
    }

    var progressLevel: Int
    get() = serviceProgress.progress
    set(value) {
        serviceProgress.progress = value
    }

    val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    init {
        layoutInflater.inflate(R.layout.customer_card_layout, this, true)
        customerNameText = rootView.findViewById(R.id.customer_name_textview)
        serviceProgress = rootView.findViewById(R.id.customer_progressbar)

        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CustomerCard)

        customerName = typedArray.getString(R.styleable.CustomerCard_CustomerName) ?: ""
        progressLevel = typedArray.getInt(R.styleable.CustomerCard_ServiceProgress, 0)

        customerNameText.text = customerName
        serviceProgress.progress = progressLevel
    }


}








