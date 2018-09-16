package `in`.raji.bills.retrosample

import `in`.raji.bills.retrosample.retro.RetroClient
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var repo = PostRepository(RetroClient.webApi)
        compositeDisposable.add(
                repo.getPosts()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ result ->
                            Log.d("Result", "There are $result Java developers in Lagos")
                            val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
                            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
                            rv.layoutManager=linearLayoutManager
                            var adapter: MyAdapter = MyAdapter(this, result)
                            rv.adapter = adapter

                        }, { error ->
                            error.printStackTrace()
                        })
        )
    }
}
