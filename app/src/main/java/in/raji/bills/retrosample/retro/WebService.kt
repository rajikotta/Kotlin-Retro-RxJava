package `in`.raji.bills.retrosample.retro

import `in`.raji.bills.retrosample.retro.data.Post
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface WebService {


    @GET("/posts")
    fun doGetListResources(): io.reactivex.Observable<List<Post>>

    companion object Factory {
        fun create(): WebService {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .build()

            return retrofit.create(WebService::class.java)
        }
    }

}