package `in`.raji.bills.retrosample.ui.activity

import `in`.raji.bills.retrosample.R
import `in`.raji.bills.retrosample.di.AppModule
import `in`.raji.bills.retrosample.di.DaggerAppComponent
import `in`.raji.bills.retrosample.retro.data.Post
import `in`.raji.bills.retrosample.ui.MainContract
import `in`.raji.bills.retrosample.ui.MainPresenter
import `in`.raji.bills.retrosample.ui.adapter.MyAdapter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {


    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDagger()
        presenter.attachView(this)

    }

    fun initDagger() {
        val activityComponent = DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()

        activityComponent.inject(this)
    }

    fun loadData(v: View) {
        presenter.showPostList()
    }


    override fun hidebutton() {
        button.visibility = View.GONE
        progressbar.visibility = View.VISIBLE

    }

    override fun showRecyclerView(result: List<Post>) {
        progressbar.visibility = View.GONE
        rv.visibility = View.VISIBLE
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv.layoutManager = linearLayoutManager
        var adapter = MyAdapter(this, result)
        rv.adapter = adapter
    }
}
