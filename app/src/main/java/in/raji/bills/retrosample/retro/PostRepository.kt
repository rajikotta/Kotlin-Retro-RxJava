package `in`.raji.bills.retrosample.retro

import `in`.raji.bills.retrosample.retro.WebApi
import `in`.raji.bills.retrosample.retro.data.Post
import retrofit2.adapter.rxjava2.Result

class PostRepository(var webservice: WebApi) {

    fun getPosts(): io.reactivex.Observable<List<Post>> {
        return webservice.doGetListResources()
    }
}
