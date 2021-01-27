package com.americanairlines.a6thkotlintpexec

import android.os.Handler
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class HandlerUtil(private val handlerUtil: Handler, private val customerList: List<RestaurantCustomer>) {

    private val CORE_POOL_SIZE = 2
    private val MAX_POOL_SIZE = 2
    private val KEEP_ALIVE_TIME = 10L

    private lateinit var restaurantManager: ThreadPoolExecutor

    private val customerQueue: BlockingQueue<Runnable> = LinkedBlockingQueue()

    fun serveExistingCustomers(){

        if(!this::restaurantManager.isInitialized)
            restaurantManager = ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, customerQueue)

        customerList.forEach {
            restaurantManager.execute(it)
        }

    }
}















