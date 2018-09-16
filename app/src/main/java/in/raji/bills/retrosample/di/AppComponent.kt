package `in`.raji.bills.retrosample.di

import `in`.raji.bills.retrosample.ui.MainPresenter
import `in`.raji.bills.retrosample.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton
import android.app.Application
import dagger.BindsInstance
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(presenter: MainPresenter)


}