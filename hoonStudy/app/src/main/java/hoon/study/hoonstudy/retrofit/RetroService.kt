package hoon.study.hoonstudy.retrofit

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("volumes")
    fun getBookListFromApi(@Query("q") query: String): Observable<BookListModel>
}