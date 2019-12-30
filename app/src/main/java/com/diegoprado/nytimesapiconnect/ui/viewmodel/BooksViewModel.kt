package com.diegoprado.nytimesapiconnect.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.diegoprado.nytimesapiconnect.data.database.ResultsBooksDatabase
import com.diegoprado.nytimesapiconnect.data.database.dao.BookDao
import com.diegoprado.nytimesapiconnect.data.database.dao.ResultDao
import com.diegoprado.nytimesapiconnect.data.database.entity.BooksEntity
//import com.diegoprado.nytimesapiconnect.data.database.entity.ResultEntity
import com.diegoprado.nytimesapiconnect.domain.CreateRequest
import com.diegoprado.nytimesapiconnect.ui.adapter.BooksAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel(application: Application): AndroidViewModel(application) {

    val booksRequest = CreateRequest().myRequest
<<<<<<< HEAD
    var listBook: ArrayList<BooksEntity.BookDetail?>? = ArrayList()
    var listAmazonLinkBook: ArrayList<BooksEntity.Results?>? = ArrayList()
    var booksData: MutableLiveData<ArrayList<BooksEntity.BookDetail?>?> = MutableLiveData()
    var bookAmazonView: MutableLiveData<ArrayList<BooksEntity.Results?>?> = MutableLiveData()
    private lateinit var resultDao: ResultDao
    private lateinit var bookDao: BookDao
    private var listResult: ArrayList<BooksEntity.Results>? = ArrayList()
=======
    var listBook: ArrayList<BooksModel.BookDetail?>? = ArrayList()
    var listAmazonLinkBook: ArrayList<BooksModel.Results?>? = ArrayList()
    var booksData: MutableLiveData<ArrayList<BooksModel.BookDetail?>?> = MutableLiveData()
    var bookAmazonView: MutableLiveData<ArrayList<BooksModel.Results?>?> = MutableLiveData()
>>>>>>> refactor

    fun requestProject(): Call<BooksEntity> {
        return booksRequest.getListBooks(api_key = "PrjQimThBNMEYoFas49esjDTl6AogMTQ")
    }

    fun createAdapter() {
        val bookObject = requestProject()
        ResultsBooksDatabase.getInstance(getApplication())?.let {
            bookDao = it.bookDetailsDao()
            resultDao = it.resultDao()
        }
        bookObject.enqueue(object : Callback<BooksEntity> {
            override fun onFailure(call: Call<BooksEntity>, t: Throwable) {
                Log.e("Teste", "Erro ao baixar dados. Mensagem: " + t.message)
            }

            override fun onResponse(call: Call<BooksEntity>, response: Response<BooksEntity>) {

            response.body().let {

                it?.result?.forEach {
                    res -> val book = res.books?.get(0)
                    listBook?.add(book)
                    listResult?.add(res)
                    listAmazonLinkBook?.add(res)
                }
            }
                bookAmazonView.value = listAmazonLinkBook
                booksData.value = listBook
                saveResultAndBook(listResult, listBook)
                BooksAdapter(listBook)
            }

        })
    }


    private fun saveResultAndBook(nameList: List<BooksEntity.Results>?, books: List<BooksEntity.BookDetail?>?) {

                if (bookDao.getCount() < books?.size ?: 0){
                nameList?.forEach {
                    resultDao.insertResult(it)
                    it.books?.let {
                        bookDao.insertBookDetail(it[0])
                    }

                    Log.d("INSERT ROOM:::", it.books?.size.toString())
                }
                }

    }

}