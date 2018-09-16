package `in`.raji.bills.retrosample.retro

import `in`.raji.bills.retrosample.retro.data.Post
import retrofit2.Call
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET



interface WebApi{


    @GET("/posts")
    fun doGetListResources():  io.reactivex.Observable<List<Post>>


}