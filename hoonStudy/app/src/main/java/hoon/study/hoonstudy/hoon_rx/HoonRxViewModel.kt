package hoon.study.hoonstudy.hoon_rx

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hoon.study.hoonstudy.retrofit.BookListModel
import hoon.study.hoonstudy.retrofit.RetroInstance
import hoon.study.hoonstudy.retrofit.RetroService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HoonRxViewModel: ViewModel() {

    lateinit var bookList: MutableLiveData<BookListModel>

    init {
        bookList = MutableLiveData()
    }

    fun makeApiCall(query: String) {
        val retrofitInstance = RetroInstance
            .getRetroInstance()
            .create(RetroService::class.java)

        retrofitInstance.getBookListFromApi(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getBookListObserverRx())
    }

    fun getBookListObserver(): MutableLiveData<BookListModel> {
        return bookList
    }

    private fun getBookListObserverRx(): Observer<BookListModel> {
        return object :Observer<BookListModel> {
            override fun onComplete() {
                // end
            }

            override fun onError(e: Throwable) {

            }

            override fun onNext(t: BookListModel) {
                bookList.postValue(t)
            }

            override fun onSubscribe(d: Disposable) {
                // start
            }
        }
    }
}