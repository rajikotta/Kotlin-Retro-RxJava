package `in`.raji.bills.retrosample.retro

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetroClient {
    companion object {
        var retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                .addConverterFactory(GsonConverterFactory.create())
                .build()
        var webApi:WebApi= retrofit.create(WebApi::class.java)
    }

}