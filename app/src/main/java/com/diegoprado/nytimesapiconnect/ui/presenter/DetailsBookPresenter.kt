package com.diegoprado.nytimesapiconnect.ui.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.diegoprado.nytimesapiconnect.R
import com.diegoprado.nytimesapiconnect.ui.adapter.BooksAdapter
import com.diegoprado.nytimesapiconnect.ui.model.BooksModel
import com.diegoprado.nytimesapiconnect.ui.viewmodel.BooksViewModel
import kotlinx.android.synthetic.main.activity_details_book_presenter.*

class DetailsBookPresenter : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var viewModel: BooksViewModel
    private var textDescription: TextView? = null
    private var itemPosition: Int? = null
    private var listLinkBook: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_book_presenter)

        webView = findViewById(R.id.wv)
        textDescription = findViewById(R.id.txtDesctipt)

        var bundle: Bundle? = intent.extras

        itemPosition = bundle?.get("positionItem").toString().toInt()

        webView.settings.javaScriptEnabled = true

        viewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)

        viewModel.booksData.observe(this, Observer<ArrayList<BooksModel.BookDetail?>?>{

           val descBook = it?.get(itemPosition!!)

           textDescription?.text = descBook?.descriptionBook
           nameBook.text = descBook?.bookName

        })

        viewModel.bookAmazonView.observe(this, Observer<ArrayList<BooksModel.Results?>?>{

            listLinkBook = it?.get(itemPosition!!)?.amazonProduct.toString()

            wv.loadUrl(listLinkBook)
        })

        viewModel.createAdapter()
    }
}
