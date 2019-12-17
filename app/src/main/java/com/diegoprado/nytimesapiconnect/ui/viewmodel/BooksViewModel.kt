package com.diegoprado.nytimesapiconnect.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.diegoprado.nytimesapiconnect.domain.CreateRequest
import com.diegoprado.nytimesapiconnect.ui.model.BooksModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel(application: Application): AndroidViewModel(application) {

    var booksData: MutableLiveData<String> = MutableLiveData()
    val booksRequest = CreateRequest().myRequest

    fun requestProject(): Call<BooksModel> {
        return booksRequest.getListBooks(api_key = "PrjQimThBNMEYoFas49esjDTl6AogMTQ")
    }

    fun showBookList(it: BooksModel?) {
        booksData.value = it?.status
    }

    fun createAdapter() {
        val bookObject = requestProject()

        bookObject.enqueue(object : Callback<BooksModel> {
            override fun onFailure(call: Call<BooksModel>, t: Throwable) {
                Log.e("Teste", "Erro ao baixar dados. Mensagem: " + t.message)
            }

            override fun onResponse(call: Call<BooksModel>, response: Response<BooksModel>) {

                response.body().let {

                    val lista = it?.status

//                    var adapter = BooksAdapter(listOf(lista))

                    Log.d("vmodel", lista)
//                    showBookList(it)
                }

            }

        })
    }
}