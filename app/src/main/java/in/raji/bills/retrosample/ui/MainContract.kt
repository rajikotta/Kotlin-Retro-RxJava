package `in`.raji.bills.retrosample.ui

import `in`.raji.bills.retrosample.retro.data.Post

interface MainContract {

    interface Presenter {

        fun showPostList() {

        }

    }

    interface View {
        fun hidebutton() {

        }

        fun showRecyclerView(result: List<Post>) {

        }
    }

    interface interactor {
        fun makeNetworkCall() {

        }
    }

}