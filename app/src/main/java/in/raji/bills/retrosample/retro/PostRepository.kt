package `in`.raji.bills.retrosample.retro

import `in`.raji.bills.retrosample.retro.data.Post

class PostRepository(var webservice: WebService) {

    fun getPosts(): io.reactivex.Observable<List<Post>> {
        return webservice.doGetListResources()
    }
}
