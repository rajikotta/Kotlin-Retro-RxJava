package `in`.raji.bills.retrosample.ui

import `in`.raji.bills.retrosample.di.AppModule
import `in`.raji.bills.retrosample.di.DaggerAppComponent
import `in`.raji.bills.retrosample.retro.PostRepository
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter : MainContract.Presenter {
    private var view: MainContract.View? = null
    @Inject
    lateinit var repository: PostRepository


    private val compositeDisposable: CompositeDisposable = CompositeDisposable()


    fun attachView(view: MainContract.View) {
        this.view = view
    }

    override fun showPostList() {
        initDagger()
        view?.hidebutton()
        compositeDisposable.add(
                repository.getPosts()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ result ->
                            Log.d("Result", "$result")
                            view?.showRecyclerView(result)
                        }, { error ->
                            error.printStackTrace()
                        })
        )

    }

    fun initDagger() {
        val activityComponent = DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()

        activityComponent.inject(this)
    }
}