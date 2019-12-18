package com.diegoprado.nytimesapiconnect.ui.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diegoprado.nytimesapiconnect.R
import com.diegoprado.nytimesapiconnect.ui.adapter.BooksAdapter
import com.diegoprado.nytimesapiconnect.ui.viewmodel.BooksViewModel

class ListBooksPresenter : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private lateinit var viewModel: BooksViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_books_presenter)

        recyclerView = findViewById(R.id.rv)

        viewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)

        viewModel.createAdapter()

        viewModel.booksData.observe(this, Observer<BooksAdapter>{
            it?.let {
                inflateList(it)
            }
        })
    }

    fun inflateList(adapter: BooksAdapter){
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = adapter

    }
}
