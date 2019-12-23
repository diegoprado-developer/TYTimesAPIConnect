package com.diegoprado.nytimesapiconnect.ui.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diegoprado.nytimesapiconnect.R
import com.diegoprado.nytimesapiconnect.ui.adapter.BooksAdapter
import com.diegoprado.nytimesapiconnect.ui.model.BooksModel
import com.diegoprado.nytimesapiconnect.ui.viewmodel.BooksViewModel

class ListBooksPresenter : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private lateinit var viewModel: BooksViewModel
    private var adapter: BooksAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_books_presenter)

        recyclerView = findViewById(R.id.rv)

        viewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)

        viewModel.booksData.observe(this, Observer<ArrayList<BooksModel.BookDetail?>?>{
            it?.let {

                var adapter = BooksAdapter(it)
                inflateList(adapter)
            }
        })

        viewModel.createAdapter()
    }

    fun inflateList(adapter: BooksAdapter){
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = adapter

        recyclerView?.addOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                Toast.makeText(this@ListBooksPresenter, "clicked on " + adapter.books!![position]?.bookName, Toast.LENGTH_SHORT).show()
                startActivityDetails(position)
            }
        })
    }

    fun startActivityDetails(pos: Int){
        val intent = Intent( applicationContext, DetailsBookPresenter::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.putExtra("positionItem", pos)
        applicationContext.startActivity(intent)
    }

    interface OnItemClickListener {
        fun onItemClicked(position: Int, view: View)
    }

    fun RecyclerView.addOnItemClickListener(onClickListener: OnItemClickListener) {
        this.addOnChildAttachStateChangeListener(object : RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewDetachedFromWindow(view: View) {
                view?.setOnClickListener(null)
            }

            override fun onChildViewAttachedToWindow(view: View) {
                view?.setOnClickListener({
                    val holder = getChildViewHolder(view)
                    onClickListener.onItemClicked(holder.adapterPosition, view)
                })
            }
        })
    }
}
