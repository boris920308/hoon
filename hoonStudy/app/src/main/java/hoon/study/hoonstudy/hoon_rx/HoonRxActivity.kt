package hoon.study.hoonstudy.hoon_rx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import hoon.study.hoonstudy.R
import hoon.study.hoonstudy.retrofit.BookListModel

class HoonRxActivity : AppCompatActivity() {

    lateinit var btnAdd: Button
    val TAG = "rxAct"
    lateinit var viewModel: HoonRxViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoon_rx)
        btnAdd = findViewById(R.id.btn_add_value)

        Log.d("rxAct", "rxActivity, onCreate()")

//        val list:List<Any> = listOf("one", 2, "three", "four", 4.5, "five", 6.0f)
//        val observable: Observable<Any> = list.toObservable()
//
//        observable.subscribeBy(
//            onNext = { Log.d("rxAct", it.toString()) },
//            onError = { it.printStackTrace() },
//            onComplete = { Log.d("rxAct", "done") }
//        )
        // -----
//        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
//
//        list.toObservable()
//            .filter { it.length >= 5 }
//            .subscribeBy(
//                onNext = {
//                    Log.d(TAG, "onNext $it")
//                },
//                onError = {
//                    Log.e(TAG, "onNext ${it.printStackTrace()}")
//                },
//                onComplete = {
//                    Log.d(TAG, "done")
//                }
//            )
        // -----

        viewModel = ViewModelProvider(this).get(HoonRxViewModel::class.java)
        viewModel.getBookListObserver().observe(this, Observer<BookListModel> {
            if (it != null) {
                Log.d(TAG, it.items.toString())
            } else {
                Toast.makeText(this, "err", Toast.LENGTH_SHORT).show()
            }
        })


        btnAdd.setOnClickListener {
            viewModel.makeApiCall("android")
        }
    }


}