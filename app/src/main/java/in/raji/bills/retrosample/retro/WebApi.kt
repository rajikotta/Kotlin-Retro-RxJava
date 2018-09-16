package `in`.raji.bills.retrosample.retro

import `in`.raji.bills.retrosample.retro.data.Post
import retrofit2.Call
import retrofit2.adapter.rxjava2.Result
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



interface WebApi{


    @GET("/posts")
    fun doGetListResources():  io.reactivex.Observable<List<Post>>

    companion object Factory {
        fun create(): WebApi {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("")
                    .build()

            return retrofit.create(WebApi::class.java)
        }
    }

}