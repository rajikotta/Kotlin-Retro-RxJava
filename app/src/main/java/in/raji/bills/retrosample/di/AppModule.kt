package `in`.raji.bills.retrosample.di

import `in`.raji.bills.retrosample.retro.PostRepository
import `in`.raji.bills.retrosample.retro.WebService
import `in`.raji.bills.retrosample.ui.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun providesMainPresenter(): MainPresenter {
        return MainPresenter()
    }

    @Singleton
    @Provides
    fun providesRepository(): PostRepository {
        return PostRepository(WebService.create())

    }
}